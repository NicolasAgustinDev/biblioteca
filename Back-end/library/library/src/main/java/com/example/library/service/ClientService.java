package com.example.library.service;

import com.example.library.dto.ClientRequestDTO;
import com.example.library.dto.ClientResponseDTO;

import java.util.List;

public interface ClientService {
    ClientResponseDTO create(ClientRequestDTO dto);
    ClientResponseDTO update(Long id, ClientRequestDTO dto);
    ClientResponseDTO findById(Long id);
    List<ClientResponseDTO> list();
    void delete(Long id);
}
