package com.example.library.controller;

import com.example.library.dto.request.ClientRequestDTO;
import com.example.library.dto.response.ClientResponseDTO;
import com.example.library.service.interfaces.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> create(@Valid @RequestBody ClientRequestDTO clientRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(clientDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> get(@PathVariable Long clientId) {
        return ResponseEntity.ok(clientService.findById(clientId));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> list() {
        return ResponseEntity.ok(clientService.list());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable Long clientId,
                                                    @Valid @RequestBody ClientRequestDTO clienteDto) {
        return ResponseEntity.ok(clientService.update(clientId, clienteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long bookId) {
        clientService.delete(bookId);
        return ResponseEntity.noContent().build();
    }
}
