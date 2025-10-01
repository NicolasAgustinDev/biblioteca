package com.example.library.service;

import com.example.library.dto.request.UserRequestDTO;
import com.example.library.dto.response.UserResponseDTO;
import com.example.library.entity.User;
import com.example.library.mapper.UserMapper;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    private final UserMapper mapper;

    public UserServiceImpl(UserRepository repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        User user = mapper.toEntity(dto);
        return mapper.toDto(repo.save(user));
    }

    @Override
    public UserResponseDTO update(Long id, UserRequestDTO dto) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        mapper.updateFromDto(dto, user);
        return mapper.toDto(repo.save(user));
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return repo.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public List<UserResponseDTO> list() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
