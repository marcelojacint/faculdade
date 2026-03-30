package com.hotel.presentation.dtos.mapper;

import com.hotel.domain.entity.TipoQuarto;
import com.hotel.presentation.dtos.response.TipoQuartoResponseDTO;

public class TipoQuartoMapper {

    public static TipoQuartoResponseDTO toDTO(TipoQuarto tipo) {
        return new TipoQuartoResponseDTO(
                tipo.getId(),
                tipo.getNome(),
                tipo.getDescricao()
        );
    }
}
