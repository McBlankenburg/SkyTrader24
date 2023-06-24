package com.skytrader24.identitymanagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String password;
    private UserRole userRole;
    private boolean isActive;
    private boolean isBlocked;
    private LocalDate creationDate;
    private LocalDate lastLoggedDate;
}