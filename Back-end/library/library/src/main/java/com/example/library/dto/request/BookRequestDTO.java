package com.example.library.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Data
public class BookRequestDTO {
    @NotBlank
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbn;
    private Integer bookYear;

    @Min(1)
    private Integer bookTotalCopies;
    private String bookCategory;
}
