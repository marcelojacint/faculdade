package com.hotel.shared.exceptions;

public class QuartoNaoEncontradoException extends RuntimeException {

    public QuartoNaoEncontradoException() {
        super("Quarto não encontrado");
    }

    public QuartoNaoEncontradoException(String message) {
        super(message);
    }
}
