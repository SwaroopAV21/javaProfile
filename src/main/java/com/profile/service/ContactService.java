package com.profile.service;

import com.profile.dto.ContactRequest;
import com.profile.model.ContactMessage;
import com.profile.repository.ContactMessageRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContactService {

    private final JavaMailSender mailSender;
    private final ContactMessageRepository contactMessageRepository;

    @Value("${portfolio.mail.to}")
    private String mailTo;

    @Value("${spring.mail.username}")
    private String mailFrom;

    public void sendContactMessage(ContactRequest req, HttpServletRequest httpRequest) {
        // 1. Persist to DB
        ContactMessage entity = ContactMessage.builder()
                .name(req.getName())
                .email(req.getEmail())
                .subject(req.getSubject())
                .message(req.getMessage())
                .sentAt(LocalDateTime.now())
                .ipAddress(getClientIp(httpRequest))
                .read(false)
                .build();
        contactMessageRepository.save(entity);

        // 2. Send email notification to portfolio owner
        sendOwnerNotification(req);

        // 3. Send auto-reply to sender
        sendAutoReply(req);

        log.info("Contact message from {} ({}) saved and emails sent.", req.getName(), req.getEmail());
    }

    private void sendOwnerNotification(ContactRequest req) {
        try {
            MimeMessage mime = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mime, true, "UTF-8");
            helper.setFrom(mailFrom);
            helper.setTo(mailTo);
            helper.setReplyTo(req.getEmail());
            helper.setSubject("[Portfolio Contact] " + (req.getSubject() != null ? req.getSubject() : "New Message"));
            helper.setText(buildOwnerEmailBody(req), true);
            mailSender.send(mime);
        } catch (Exception e) {
            log.error("Failed to send owner notification email: {}", e.getMessage());
        }
    }

    private void sendAutoReply(ContactRequest req) {
        try {
            MimeMessage mime = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mime, true, "UTF-8");
            helper.setFrom(mailFrom);
            helper.setTo(req.getEmail());
            helper.setSubject("Thanks for reaching out!");
            helper.setText(buildAutoReplyBody(req), true);
            mailSender.send(mime);
        } catch (Exception e) {
            log.error("Failed to send auto-reply email: {}", e.getMessage());
        }
    }

    private String buildOwnerEmailBody(ContactRequest req) {
        return """
            <html><body style="font-family: monospace; background:#0a0a0a; color:#00ff88; padding:24px;">
            <h2 style="color:#00ff88;">[ NEW CONTACT MESSAGE ]</h2>
            <table style="border-collapse:collapse; width:100%%;">
              <tr><td style="padding:8px; color:#888;">From:</td><td style="padding:8px;">%s</td></tr>
              <tr><td style="padding:8px; color:#888;">Email:</td><td style="padding:8px;"><a href="mailto:%s" style="color:#00d4ff;">%s</a></td></tr>
              <tr><td style="padding:8px; color:#888;">Subject:</td><td style="padding:8px;">%s</td></tr>
            </table>
            <hr style="border-color:#333; margin:16px 0;"/>
            <p style="color:#aaa;">Message:</p>
            <div style="background:#111; padding:16px; border-left:3px solid #00ff88; white-space:pre-wrap;">%s</div>
            </body></html>
            """.formatted(
                req.getName(), req.getEmail(), req.getEmail(),
                req.getSubject() != null ? req.getSubject() : "(no subject)",
                req.getMessage()
        );
    }

    private String buildAutoReplyBody(ContactRequest req) {
        return """
            <html><body style="font-family: monospace; background:#0a0a0a; color:#e0e0e0; padding:24px;">
            <h2 style="color:#00ff88;">Thanks, %s!</h2>
            <p>I received your message and will get back to you as soon as possible.</p>
            <hr style="border-color:#333;"/>
            <p style="color:#888; font-size:12px;">Your message:</p>
            <blockquote style="color:#aaa; border-left:3px solid #333; margin-left:0; padding-left:16px;">%s</blockquote>
            </body></html>
            """.formatted(req.getName(), req.getMessage());
    }

    private String getClientIp(HttpServletRequest request) {
        String xff = request.getHeader("X-Forwarded-For");
        return (xff != null && !xff.isEmpty()) ? xff.split(",")[0].trim() : request.getRemoteAddr();
    }
}