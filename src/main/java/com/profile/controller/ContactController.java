package com.profile.controller;

import com.profile.dto.ApiResponse;
import com.profile.dto.ContactRequest;
import com.profile.service.ContactService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/contact")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> sendMessage(
            @Valid @RequestBody ContactRequest request,
            HttpServletRequest httpRequest) {
        contactService.sendContactMessage(request, httpRequest);
        return ResponseEntity.ok(
            ApiResponse.ok("Message sent successfully. I'll get back to you soon!", null)
        );
    }
}