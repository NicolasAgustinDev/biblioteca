package com.example.library.dto.response;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDTO {
    private Long id;
    private Long bookId;
    private String bookTitle;
    private Long clientEmail;
    private String clientName;
    private Long userId;
    private LocalDate date;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private boolean delivery;
}

