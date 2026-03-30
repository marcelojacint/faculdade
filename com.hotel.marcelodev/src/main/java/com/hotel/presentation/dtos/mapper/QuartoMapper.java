package com.hotel.presentation.dtos.mapper;

import com.hotel.domain.entity.Quarto;
import com.hotel.presentation.dtos.response.QuartoResponseDTO;

public class QuartoMapper {

    public static QuartoResponseDTO toDTO(Quarto quarto) {
        return new QuartoResponseDTO(
                quarto.getId(),
                quarto.getNumero(),
                quarto.getAndar(),
                quarto.getStatus().name(),
                quarto.getTipo() != null ? quarto.getTipo().getNome() : null
        );
    }
}