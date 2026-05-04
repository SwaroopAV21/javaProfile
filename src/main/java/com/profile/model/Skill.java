package com.profile.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;   // e.g. "Backend", "Frontend", "DevOps", "Database"

    private int proficiency;   // 0–100

    @Column(name = "icon_key")
    private String iconKey;    // Maps to a devicon / custom icon slug on frontend

    @Column(name = "sort_order")
    private int sortOrder;
}