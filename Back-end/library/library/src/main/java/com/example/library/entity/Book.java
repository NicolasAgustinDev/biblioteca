package com.example.library.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// La importación de org.springframework.data.annotation.Id ha sido eliminada.

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {

    @Id // Usa jakarta.persistence.Id
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
        // Asume que al crear el libro, todas las copias están disponibles inicialmente.
        if (availableCopies == null) {
            availableCopies = totalCopies;
        }
    }

    @PreUpdate
    public void preUpdate() { updatedAt = LocalDateTime.now(); }
}