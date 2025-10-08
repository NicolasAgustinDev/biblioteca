package com.example.library.controller;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import com.example.library.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public LoanResponseDTO create(@RequestBody LoanRequestDTO loanDto) {
        return this.loanService.createLoan(loanDto);
    }

    @PutMapping("/{id}/return")
    public LoanResponseDTO DeliveryLoan(@PathVariable Long loanId) {
        return this.loanService.returnLoan(loanId);
    }

    @GetMapping
    public List<LoanResponseDTO> getAll() {
        return this.loanService.getAll();
    }

    @GetMapping("/{id}")
    public LoanResponseDTO getById(@PathVariable Long loanId) {
        return this.loanService.getById(loanId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long loanId) {
        loanService.delete(loanId);
    }
}
