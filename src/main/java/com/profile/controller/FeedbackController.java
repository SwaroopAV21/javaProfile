package com.profile.controller;

import com.profile.dto.ApiResponse;
import com.profile.dto.FeedbackRequest;
import com.profile.service.FeedbackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/feedback")
@RequiredArgsConstructor
public class FeedbackController {

    private final FeedbackService feedbackService;

    @PostMapping
    public ResponseEntity<ApiResponse<String>>  sendFeedback(
            @Valid @RequestBody FeedbackRequest request){
        feedbackService.saveFeedback(request);
        return ResponseEntity.ok(
            ApiResponse.ok("Feedback sent successfully. Thank you for your feedback!", null)
        );
    }
}
