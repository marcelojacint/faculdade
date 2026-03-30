package com.hotel.presentation.controller;

import com.hotel.domain.service.QuartoService;
import com.hotel.presentation.dtos.AlterarStatusQuartoDTO;
import com.hotel.presentation.dtos.mapper.QuartoMapper;
import com.hotel.presentation.dtos.request.QuartoRequestDTO;
import com.hotel.presentation.dtos.response.QuartoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quartos")
@RequiredArgsConstructor
public class QuartoController {

    private final QuartoService service;

    @GetMapping("/disponiveis")
    public ResponseEntity<List<QuartoResponseDTO>> listarDisponiveis() {

        var response = service.listarDisponiveis()
                .stream()
                .map(QuartoMapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<QuartoResponseDTO>> listar() {

        var response = service.listar()
                .stream()
                .map(QuartoMapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<QuartoResponseDTO> cadastrar(@RequestBody QuartoRequestDTO dto) {

        var quarto = service.cadastrar(dto);

        return ResponseEntity.status(201).body(QuartoMapper.toDTO(quarto));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> alterarStatus(
            @PathVariable Long id,
            @RequestBody AlterarStatusQuartoDTO dto) {

        service.alterarStatus(id, dto);

        return ResponseEntity.noContent().build();
    }
}
