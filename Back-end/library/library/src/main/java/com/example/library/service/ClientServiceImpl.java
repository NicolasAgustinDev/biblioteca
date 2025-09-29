package com.example.library.service.impl;

import com.example.library.dto.ClientRequestDTO;
import com.example.library.dto.ClientResponseDTO;
import com.example.library.entity.Client;
import com.example.library.mapper.ClientMapper;
import com.example.library.repository.ClientRepository;
import com.example.library.service.ClientService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repo;
    private final ClientMapper mapper;

    public ClientServiceImpl(ClientRepository repo, ClientMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public ClientResponseDTO create(ClientRequestDTO dto) {
        Client client = mapper.toEntity(dto);
        return mapper.toDto(repo.save(client));
    }

    @Override
    public ClientResponseDTO update(Long id, ClientRequestDTO dto) {
        Client client = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        mapper.updateFromDto(dto, client);
        return mapper.toDto(repo.save(client));
    }

    @Override
    public ClientResponseDTO findById(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    @Override
    public List<ClientResponseDTO> list() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
