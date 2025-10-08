package com.example.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
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