package com.profile.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ContactRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be 2–100 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;

    @Size(max = 200, message = "Subject max 200 characters")
    private String subject;

    @NotBlank(message = "Message is required")
    @Size(min = 10, max = 5000, message = "Message must be 10–5000 characters")
    private String message;
}