package com.example.library.service;

import com.example.library.dto.request.ClientRequestDTO;
import com.example.library.dto.response.ClientResponseDTO;

import java.util.List;

public interface ClientService {
    ClientResponseDTO create(ClientRequestDTO clientDto);
    ClientResponseDTO update(Long clientId, ClientRequestDTO clientDto);
    ClientResponseDTO findById(Long clientId);
    List<ClientResponseDTO> list();
    void delete(Long clientId);
}
