package com.example.library.service;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import java.util.List;

public interface LoanService {
    LoanResponseDTO createLoan(LoanRequestDTO loanDto);
    LoanResponseDTO returnLoan(Long loanId);
    List<LoanResponseDTO> getAll();
    LoanResponseDTO getById(Long loanId);
    void delete(Long loanId);
}
