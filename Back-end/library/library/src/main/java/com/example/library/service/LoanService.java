package com.example.library.service;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;

import java.util.List;

public interface LoanService {
    LoanResponseDTO createLoan(LoanRequestDTO dto);
    List<LoanResponseDTO> getAllLoans();
    LoanResponseDTO getLoanById(Long id);
    LoanResponseDTO returnLoan(Long id); // NUEVO
    void deleteLoan(Long id);
}
