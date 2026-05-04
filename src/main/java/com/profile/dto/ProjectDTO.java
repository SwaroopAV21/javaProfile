package com.profile.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

// ---- Project DTO ----
public class ProjectDTO {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class Response {
        private Long id;
        private String title;
        private String description;
        private String shortDesc;
        private String[] techStack;
        private String githubUrl;
        private String liveUrl;
        private String imageUrl;
        private boolean featured;
        private int sortOrder;
        private LocalDate startDate;
        private LocalDate endDate;
    }
}

// ---- Skill DTO ----
class SkillDTO {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class Response {
        private Long id;
        private String name;
        private String category;
        private int proficiency;
        private String iconKey;
        private int sortOrder;
    }
}

// ---- Experience DTO ----
class ExperienceDTO {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class Response {
        private Long id;
        private String company;
        private String role;
        private String description;
        private String location;
        private LocalDate startDate;
        private LocalDate endDate;
        private boolean current;
        private String[] techUsed;
        private int sortOrder;
    }
}