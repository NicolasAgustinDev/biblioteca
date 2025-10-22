package com.example.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "books")
public class BookEntity {
    @Id//especificar estrategia de autoincrementar identity
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private Integer year;
    private LocalDate publishedDate;
    private Integer availableCopies;
    private Integer totalCopies;
    private String category;
}
