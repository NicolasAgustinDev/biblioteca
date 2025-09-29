package com.example.library.service;

import com.example.library.dto.LoanRequestDTO;
import com.example.library.dto.LoanResponseDTO;

import java.util.List;

public interface LoanService {
    LoanResponseDTO create(LoanRequestDTO dto);
    LoanResponseDTO returnLoan(Long id);
    LoanResponseDTO findById(Long id);
    List<LoanResponseDTO> list();
    void delete(Long id);
}
