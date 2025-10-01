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
    public LoanResponseDTO create(@RequestBody LoanRequestDTO dto) {
        return loanService.createLoan(dto);
    }

    @PutMapping("/{id}/return")
    public LoanResponseDTO returnLoan(@PathVariable Long id) {
        return loanService.returnLoan(id);
    }

    @GetMapping
    public List<LoanResponseDTO> getAll() {
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public LoanResponseDTO getById(@PathVariable Long id) {
        return loanService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        loanService.delete(id);
    }
}
