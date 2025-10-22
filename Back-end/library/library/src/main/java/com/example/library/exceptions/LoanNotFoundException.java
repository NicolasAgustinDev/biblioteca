package com.example.library.exceptions;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(Long id)
    {
        super(String.format("Prestamo no encontrado: %d",id));
    }
}
