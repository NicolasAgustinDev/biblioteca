package com.example.library.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class UserEntity {

    @Id
    private String username;

    private String userPassword;
    private String userFullName;
    private Boolean userEnabled = true;
    private LocalDateTime userCreatedAt;

    @PrePersist
    public void prePersist() { userCreatedAt = LocalDateTime.now(); }
}