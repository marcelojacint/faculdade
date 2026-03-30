package com.hotel.presentation.dtos.request;

public record QuartoRequestDTO(
        String numero,
        String andar,
        Long tipoId
) {}
