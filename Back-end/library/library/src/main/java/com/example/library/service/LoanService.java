package com.example.library.service;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import java.util.List;

public interface LoanService {
    LoanResponseDTO createLoan(LoanRequestDTO dto);
    LoanResponseDTO returnLoan(Long id);
    List<LoanResponseDTO> getAll();
    LoanResponseDTO getById(Long id);
    void delete(Long id);
}
