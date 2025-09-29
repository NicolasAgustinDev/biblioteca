package com.example.library.repository;

import com.example.library.entity.Book;
import com.example.library.entity.Client;
import com.example.library.entity.Loan;
import com.example.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface repository {
    public interface BookRepository extends JpaRepository<Book, Long> {
        Optional<Book> findByIsbn(String isbn);
    }

    public interface ClientRepository extends JpaRepository<Client, Long> {}

    public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String username);
    }

    public interface LoanRepository extends JpaRepository<Loan, Long> {
        List<Loan> findByClientId(Long clientId);
    }

}
