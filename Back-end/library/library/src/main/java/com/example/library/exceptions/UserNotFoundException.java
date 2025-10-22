package com.example.library.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {

        super(String.format("Usuario no encontrado: %s",username ));
    }
}
