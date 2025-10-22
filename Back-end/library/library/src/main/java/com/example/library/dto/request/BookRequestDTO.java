package com.example.library.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
    @NotBlank
    private String title;
    private String author;
    private String isbn;
    private Integer year;

    @Min(1)
    private Integer totalCopies;
    private String category;
}
