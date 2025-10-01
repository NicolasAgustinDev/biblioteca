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

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;
    private final LoanMapper loanMapper;

    public LoanServiceImpl(LoanRepository loanRepository, BookRepository bookRepository,
                           ClientRepository clientRepository, UserRepository userRepository,
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
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        User user = null;
        if (dto.getUserId() != null) {
            user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        }

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setClient(client);
        loan.setUser(user);
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(dto.getDueDate());
        loan.setStatus("ACTIVO");

        return loanMapper.toDto(loanRepository.save(loan));
    }

    @Override
    public LoanResponseDTO returnLoan(Long id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        loan.setStatus("DEVUELTO");
        loan.setReturnDate(LocalDate.now());

        return loanMapper.toDto(loanRepository.save(loan));
    }

    @Override
    public List<LoanResponseDTO> getAll() {
        return loanRepository.findAll()
                .stream().map(loanMapper::toDto).toList();
    }

    @Override
    public LoanResponseDTO getById(Long id) {
        return loanRepository.findById(id)
                .map(loanMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
    }

    @Override
    public void delete(Long id) {
        loanRepository.deleteById(id);
    }
}

