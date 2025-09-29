package com.example.library.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BookRequestDTO {
    @NotBlank
    private String title;
    private String author;
    private String isbn;
    private Integer year;
    @Min(1) private Integer totalCopies;
    private String category;
}
