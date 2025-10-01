package com.example.library.controller;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import com.example.library.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LoanResponseDTO> create(@Valid @RequestBody LoanRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createLoan(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getLoanById(id));
    }

    @GetMapping
    public ResponseEntity<List<LoanResponseDTO>> list() {
        return ResponseEntity.ok(service.getAllLoans());
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<LoanResponseDTO> returnLoan(@PathVariable Long id) {
        return ResponseEntity.ok(service.returnLoan(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
