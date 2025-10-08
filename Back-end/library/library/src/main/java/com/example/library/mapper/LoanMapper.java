package com.example.library.mapper;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import com.example.library.entity.BookEntity;
import com.example.library.entity.ClientEntity;
import com.example.library.entity.LoanEntity;
import com.example.library.entity.UserEntity;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ClientRepository;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    public LoanMapper(BookRepository bookRepository, ClientRepository clientRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    public LoanEntity toEntity(LoanRequestDTO loanDto) {
        LoanEntity loanEntity = new LoanEntity();

        BookEntity book = bookRepository.findById(loanDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        ClientEntity client = clientRepository.findById(loanDto.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

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

    public LoanResponseDTO toDTO(LoanEntity LoanEntity) {
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

        return loanDto;
    }
}
