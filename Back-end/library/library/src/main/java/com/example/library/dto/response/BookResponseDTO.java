package com.example.library.dto.response;

import java.time.LocalDateTime;

public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer year;
    private Integer totalCopies;
    private Integer availableCopies;
    private String category;
    private LocalDateTime createdAt;
}
