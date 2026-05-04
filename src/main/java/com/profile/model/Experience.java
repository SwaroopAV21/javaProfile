package com.profile.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "experiences")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String role;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String location;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")  // null = current job
    private LocalDate endDate;

    @Column(name = "is_current")
    private boolean current;

    @Column(name = "tech_used")
    private String techUsed;   // comma-separated

    @Column(name = "sort_order")
    private int sortOrder;
}