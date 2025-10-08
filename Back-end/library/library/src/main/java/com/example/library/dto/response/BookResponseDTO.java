package com.example.library.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookResponseDTO {
    private Long bookId;
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;
    private Integer bookYear;
    private Integer bookTotalCopies;
    private String bookCategory;
    private LocalDate bookPublishedDate;
    private Integer bookAvailableCopies;
}
