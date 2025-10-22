package com.example.library.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id){

        super (String.format("Libro no encontrdo: %d", id));
    }
}
