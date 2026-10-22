package com.profile.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "sessions")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userId;


    @Column(name = "sessionId")
    private String sessionId;

    @Column(name = "refreshToken")
    private String refreshToken;

    @Column(name = "sessionGeneratedDate")
    private LocalDate loginDate;

    @Column(name = "sessionGeneratedTime")
    private LocalTime loginTime;

}
