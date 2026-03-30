package com.hotel.presentation.dtos.response;

public record QuartoResponseDTO(
    Long id,
    String numero,
    String andar,
    String status,
    String tipo
) {}
