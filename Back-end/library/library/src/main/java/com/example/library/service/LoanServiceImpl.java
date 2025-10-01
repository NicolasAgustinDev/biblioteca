package com.example.library.service;

import com.example.library.dto.request.LoanRequestDTO;
import com.example.library.dto.response.LoanResponseDTO;
import com.example.library.entity.Book;
import com.example.library.entity.Client;
import com.example.library.entity.Loan;
import com.example.library.entity.User;
import com.example.library.mapper.LoanMapper;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ClientRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final LoanMapper loanMapper;

    public LoanServiceImpl(LoanRepository loanRepository,
                           BookRepository bookRepository,
                           ClientRepository clientRepository,
                           UserRepository userRepository,
                           LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
        this.loanMapper = loanMapper;
    }

    @Override
    public LoanResponseDTO createLoan(LoanRequestDTO dto) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        User user = null;
        if (dto.getUserId() != null) {
            user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setClient(client);
        loan.setUser(user);
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(dto.getDueDate());
        loan.setStatus("Activo");

        Loan savedLoan = loanRepository.save(loan);
        return loanMapper.toDto(savedLoan);
    }

    @Override
    public List<LoanResponseDTO> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LoanResponseDTO getLoanById(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        return loanMapper.toDto(loan);
    }

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
