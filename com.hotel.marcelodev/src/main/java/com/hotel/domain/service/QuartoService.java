package com.hotel.domain.service;


import com.hotel.domain.entity.Quarto;
import com.hotel.domain.entity.TipoQuarto;
import com.hotel.domain.enums.StatusQuarto;
import com.hotel.infrastructure.repository.QuartoRepository;
import com.hotel.infrastructure.repository.TipoQuartoRepository;
import com.hotel.presentation.dtos.AlterarStatusQuartoDTO;
import com.hotel.presentation.dtos.request.QuartoRequestDTO;
import com.hotel.shared.exceptions.NegocioException;
import com.hotel.shared.exceptions.QuartoNaoEncontradoException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuartoService {

    private final QuartoRepository quartoRepository;
    private final TipoQuartoRepository tipoRepository;

    public List<Quarto> listar() {
        return quartoRepository.findAll();
    }

    public List<Quarto> listarDisponiveis() {

        List<Quarto> quartos = quartoRepository.findByStatus(StatusQuarto.DISPONIVEL);

        if (quartos.isEmpty()) {
            throw new QuartoNaoEncontradoException("Nenhum quarto disponível");
        }

        return quartos;
    }

    public Quarto cadastrar(QuartoRequestDTO dto) {

        if (dto.numero() == null || dto.numero().isBlank()) {
            throw new NegocioException("Número do quarto é obrigatório");
        }

        if (quartoRepository.existsByNumero(dto.numero())) {
            throw new NegocioException("Número do quarto já existe");
        }

        TipoQuarto tipo = tipoRepository.findById(dto.tipoId())
                .orElseThrow(() -> new NegocioException("Tipo não encontrado"));

        Quarto quarto = new Quarto(
                null,
                dto.numero(),
                dto.andar(),
                StatusQuarto.DISPONIVEL,
                tipo
        );

        return quartoRepository.save(quarto);
    }

    public void alterarStatus(Long id, AlterarStatusQuartoDTO dto) {

        Quarto quarto = quartoRepository.findById(id)
                .orElseThrow(QuartoNaoEncontradoException::new);

        StatusQuarto novoStatus = StatusQuarto.valueOf(dto.status());

        if (quarto.getStatus() == StatusQuarto.MANUTENCAO
                && novoStatus == StatusQuarto.OCUPADO) {
            throw new NegocioException("Quarto em manutenção não pode ser ocupado");
        }

        quarto.setStatus(novoStatus);

        quartoRepository.save(quarto);
    }
}
