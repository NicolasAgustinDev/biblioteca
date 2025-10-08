package com.example.library.service;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import com.example.library.entity.LoanEntity;
import com.example.library.mapper.LoanMapper;
import com.example.library.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl {

    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    public LoanServiceImpl(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }

    public LoanResponseDTO createLoan(LoanRequestDTO loanDto) {
        LoanEntity loanEntity = loanMapper.toEntity(loanDto);
        loanRepository.save(loanEntity);
        return loanMapper.toDTO(loanEntity);
    }

    public List<LoanResponseDTO> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toDTO)
                .collect(Collectors.toList());
    }

    public LoanResponseDTO getLoanById(Long loanId) {
        LoanEntity loanEntity = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
        return loanMapper.toDTO(loanEntity);
    }

    public LoanResponseDTO returnLoan(Long loanId) {
        LoanEntity loanEntity = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        loanEntity.setLoanReturned(true);
        loanEntity.setLoanReturnDate(LocalDate.now());
        loanRepository.save(loanEntity);

        return loanMapper.toDTO(loanEntity);
    }

    public void deleteLoan(Long loanId) {
        loanRepository.deleteById(loanId);
    }
}
