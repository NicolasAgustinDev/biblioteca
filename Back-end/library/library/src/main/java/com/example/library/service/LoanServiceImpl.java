package com.example.library.service;

import com.example.library.dto.LoanRequestDTO;
import com.example.library.dto.LoanResponseDTO;
import com.example.library.entity.Book;
import com.example.library.entity.Client;
import com.example.library.entity.Loan;
import com.example.library.entity.User;
import com.example.library.repository.BookRepository;
import com.example.library.repository.ClientRepository;
import com.example.library.repository.LoanRepository;
import com.example.library.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepo;
    private final BookRepository bookRepo;
    private final ClientRepository clientRepo;
    private final UserRepository userRepo;

    public LoanServiceImpl(LoanRepository l, BookRepository b, ClientRepository c, UserRepository u) {
        this.loanRepo = l;
        this.bookRepo = b;
        this.clientRepo = c;
        this.userRepo = u;
    }

    @Override
    public LoanResponseDTO create(LoanRequestDTO dto) {
        Book book = bookRepo.findById(dto.getBookId())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
        if (book.getAvailableCopies() <= 0)
            throw new RuntimeException("No hay ejemplares disponibles");

        Client client = clientRepo.findById(dto.getClientId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        User user = null;
        if (dto.getUserId() != null) {
            user = userRepo.findById(dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        }

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setClient(client);
        loan.setUser(user);
        loan.setLoanDate(LocalDate.now());
        loan.setDueDate(dto.getDueDate());
        loan.setStatus("ACTIVE");

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        Loan saved = loanRepo.save(loan);
        return mapToDto(saved);
    }

    @Override
    public LoanResponseDTO returnLoan(Long id) {
        Loan loan = loanRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));
        loan.setReturnDate(LocalDate.now());
        loan.setStatus("RETURNED");

        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);

        return mapToDto(loanRepo.save(loan));
    }

    @Override
    public LoanResponseDTO findById(Long id) {
        return null;
    }

    @Override
    public List<LoanResponseDTO> list() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    private LoanResponseDTO mapToDto(Loan loan) {
        LoanResponseDTO dto = new LoanResponseDTO();
        dto.setId(loan.getId());
        dto.setBookId(loan.getBook().getId());
        dto.setBookTitle(loan.getBook().getTitle());
        dto.setClientId(loan.getClient().getId());
        dto.setClientName(loan.getClient().getName());
        dto.setUserId(loan.getUser() != null ? loan.getUser().getId() : null);
        dto.setLoanDate(loan.getLoanDate());
        dto.setDueDate(loan.getDueDate());
        dto.setReturnDate(loan.getReturnDate());
        dto.setStatus(loan.getStatus());
        return dto;
    }
}
