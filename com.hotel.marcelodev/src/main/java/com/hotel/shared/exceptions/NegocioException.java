package com.hotel.shared.exceptions;

public class NegocioException extends RuntimeException {

    public NegocioException(String message) {
        super(message);
    }
}
