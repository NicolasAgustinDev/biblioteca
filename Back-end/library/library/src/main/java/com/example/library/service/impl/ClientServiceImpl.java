package com.example.library.service.impl;

import com.example.library.dto.request.ClientRequestDTO;
import com.example.library.dto.response.ClientResponseDTO;
import com.example.library.entity.ClientEntity;
import com.example.library.exceptions.BookNotFoundException;
import com.example.library.exceptions.ClientNotFoundException;
import com.example.library.mapper.ClientMapper;
import com.example.library.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public ClientResponseDTO createClient(ClientRequestDTO requestDTO) {
        ClientEntity clientEntity = clientMapper.toEntity(requestDTO);
        clientRepository.save(clientEntity);
        return clientMapper.toDTO(clientEntity);
    }

    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientResponseDTO getClientById(String email) {
        ClientEntity entity = clientRepository.findById(email)
                .orElseThrow(() -> new ClientNotFoundException(email));
        return clientMapper.toDTO(entity);
    }

    public ClientResponseDTO updateClient(String email, ClientRequestDTO requestDTO) {
        ClientEntity clientEntity = clientRepository.findById(email)
                .orElseThrow(() -> new ClientNotFoundException(email));

        clientEntity.setClientName(requestDTO.getClientName());
        clientEntity.setClientEmail(requestDTO.getClientEmail());
        clientEntity.setClientPhone(requestDTO.getClientPhone());
        clientEntity.setClientAddress(requestDTO.getClientAddress());

        clientRepository.save(clientEntity);
        return clientMapper.toDTO(clientEntity);
    }

    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }
}
