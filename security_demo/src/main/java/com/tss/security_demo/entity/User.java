package com.tss.security_demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @Column(name = "isActive")
    private Boolean isActive = true;

    @Column(name = "failed_login_count")
    private Integer failedLoginCount =0;

    @Column(name = "locked_until")
    private LocalDateTime lockedUntil;

    //@CreatedDate
    @Column(name = "created_at")
    private LocalDate createdAt;

    //@LastModifiedDate
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate()
    {
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDate.now();
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }
}
