package com.example.library.exceptions;

import jakarta.validation.constraints.NotNull;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String email)
    {
        super(String.format("Cliente no encontrado: %s",email));
    }
}
