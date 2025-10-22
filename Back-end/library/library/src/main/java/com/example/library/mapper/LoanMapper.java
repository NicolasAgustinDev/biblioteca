package com.example.library.mapper;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import com.example.library.entity.BookEntity;
import com.example.library.entity.ClientEntity;
import com.example.library.entity.LoanEntity;
import com.example.library.entity.UserEntity;
import com.example.library.exceptions.BookNotFoundException;
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
                .orElseThrow(() -> new BookNotFoundException(loanDto.getBookId())); // crea una exception persoanlizada

        ClientEntity client = clientRepository.findById(loanDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado")); // crea una expcepcion personalizada

        loanEntity.setBook(book);
        loanEntity.setClient(client);
        loanEntity.setLoanDueDate(loanDto.getLoanDueDate());

        if (loanDto.getUserId() != null) {
            UserEntity user = userRepository.findById(loanDto.getUserId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            loanEntity.setUser(user);
        }

        return loanEntity;
    }

    public LoanResponseDTO toDTO(LoanEntity entity) {

        return LoanResponseDTO.builder()
                .loanId(entity.getLoanId())



                .build();
        /*
        LoanResponseDTO loanDto = new LoanResponseDTO();

        loanDto.setLoanId(LoanEntity.getLoanId());
        loanDto.setBookId(LoanEntity.getBook().getBookId());
        loanDto.setBookTitle(LoanEntity.getBook().getBookTitle());
        loanDto.setClientId(LoanEntity.getClient().getClientId());
        loanDto.setClientName(LoanEntity.getClient().getClientName());
        loanDto.setLoanDate(LoanEntity.getLoanDate());
        loanDto.setLoanDueDate(LoanEntity.getLoanDueDate());
        loanDto.setLoanReturnDate(LoanEntity.getLoanReturnDate());
        loanDto.setLoanDelivery(LoanEntity.isLoanDelivery());
        if (LoanEntity.getUser() != null) {
            loanDto.setUserId(LoanEntity.getUser().getUsername());
        }

        return loanDto;*/
    }
}
