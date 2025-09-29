package com.example.library.entity;

import jakarta.persistence.*; // Se importa Id, Entity, Table, GeneratedValue, Column, PrePersist
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// La importación de org.springframework.data.annotation.Id ha sido eliminada.

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Client {

    @Id // Usa jakarta.persistence.Id (importado con jakarta.persistence.*)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String email;

    private String phone;
    private String address;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() { createdAt = LocalDateTime.now(); }
}