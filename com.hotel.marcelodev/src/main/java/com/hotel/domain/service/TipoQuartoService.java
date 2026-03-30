package com.hotel.domain.service;


import com.hotel.domain.entity.TipoQuarto;
import com.hotel.infrastructure.repository.TipoQuartoRepository;
import com.hotel.presentation.dtos.request.TipoQuartoRequestDTO;
import com.hotel.shared.exceptions.NegocioException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoQuartoService {

    private final TipoQuartoRepository repository;

    public TipoQuarto cadastrar(TipoQuartoRequestDTO dto) {

        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new NegocioException("Nome é obrigatório");
        }

        TipoQuarto tipo = new TipoQuarto(
                null,
                dto.nome(),
                dto.descricao()
        );

        return repository.save(tipo);
    }

    public List<TipoQuarto> listar() {
        return repository.findAll();
    }
}


