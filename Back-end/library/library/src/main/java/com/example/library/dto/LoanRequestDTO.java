package com.example.library.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class LoanRequestDTO {
    @NotNull
    private Long bookId;
    @NotNull
    private Long clientId;
    @NotNull
    private LocalDate dueDate;
    private Long userId; // opcional

    // getters y setters
    public Long getBookId() { return bookId; }
    public void setBookId(Long bookId) { this.bookId = bookId; }

    public Long getClientId() { return clientId; }
    public void setClientId(Long clientId) { this.clientId = clientId; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
