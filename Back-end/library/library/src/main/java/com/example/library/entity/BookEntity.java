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
    @Id
    private Long bookId;

    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;
    private Integer bookYear;
    private LocalDate bookPublishedDate;
    private Integer bookAvailableCopies;
    private Integer bookTotalCopies;
    private String bookCategory;
}
