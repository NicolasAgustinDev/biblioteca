package com.example.library.mapper;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import com.example.library.entity.BookEntity;
import com.example.library.entity.ClientEntity;
import com.example.library.entity.LoanEntity;
import com.example.library.entity.UserEntity;
import com.example.library.exceptions.BookNotFoundException;
import com.example.library.exceptions.ClientNotFoundException;
import com.example.library.exceptions.UserNotFoundException;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ClientRepository;
import com.example.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoanMapper {

    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;


    public LoanEntity toEntity(LoanRequestDTO loanDto) {
        LoanEntity loanEntity = new LoanEntity();

        BookEntity book = bookRepository.findById(loanDto.getBookId())
                .orElseThrow(() -> new BookNotFoundException(loanDto.getBookId()));

        ClientEntity client = clientRepository.findById(loanDto.getClientEmail())
                .orElseThrow(() -> new ClientNotFoundException(loanDto.getClientEmail()));

        loanEntity.setBook(book);
        loanEntity.setClient(client);
        loanEntity.setLoanDueDate(loanDto.getLoanDueDate());

        if (loanDto.getUserId() != null) {
            UserEntity user = userRepository.findById(loanDto.getUserId())
                    .orElseThrow(() -> new UserNotFoundException(loanDto.getUserId()));
            loanEntity.setUser(user);
        }

        return loanEntity;
    }

    public LoanResponseDTO toDTO(LoanEntity entity) {

        return LoanResponseDTO.builder()
                .id(entity.getId())
                .bookId(entity.getBook().getId())
                .bookTitle(entity.getBook().getTitle())
                .clientEmail(entity.getClient().getEmail())
                .clientName(entity.getClient().getName())
                .date(entity.getDate())
                .dueDate(entity.getDueDate())
                .returnDate(entity.getReturnDate())
                .delivery(entity.isDelivery())
                .build();

    }
}
