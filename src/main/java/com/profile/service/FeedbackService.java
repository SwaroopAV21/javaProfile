package com.profile.service;

import com.profile.dto.FeedbackRequest;
import com.profile.model.Feedback;
import com.profile.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedbackService {

    private  final FeedbackRepository feedbackRepository;

    public void saveFeedback(FeedbackRequest request) {
        // Save feedback to the database
        Feedback  feedback = Feedback.builder()
                .name(request.getName())
                .email(request.getEmail())
                .type(request.getType())
                .rating(request.getRating())
                .message(request.getMessage())
                .build();
        feedbackRepository.save(feedback);
        log.info("Feedback from {} ({}) saved successfully.", request.getName(), request.getEmail());
    }
}
