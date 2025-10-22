package com.example.library.dto.response;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private Integer year;
    private Integer totalCopies;
    private String category;
    private LocalDate publishedDate;
    private Integer availableCopies;
}
