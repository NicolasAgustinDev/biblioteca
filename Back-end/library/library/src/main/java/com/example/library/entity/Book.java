package com.example.library.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String author;
    @Column(unique = true)
    private String isbn;
    private Integer year;
    private Integer totalCopies;
    private Integer availableCopies;
    private String category;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
        availableCopies = totalCopies;
    }
    @PreUpdate
    public void preUpdate() { updatedAt = LocalDateTime.now(); }
    // getters/setters
}
