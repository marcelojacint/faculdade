package com.hotel.presentation.controller;

import com.hotel.domain.entity.TipoQuarto;
import com.hotel.domain.service.TipoQuartoService;
import com.hotel.presentation.dtos.mapper.TipoQuartoMapper;
import com.hotel.presentation.dtos.request.TipoQuartoRequestDTO;
import com.hotel.presentation.dtos.response.TipoQuartoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-quarto")
@RequiredArgsConstructor
public class TipoQuartoController {

    private final TipoQuartoService service;

    @PostMapping
    public ResponseEntity<TipoQuarto> cadastrar(@RequestBody TipoQuartoRequestDTO dto) {

        TipoQuarto tipo = service.cadastrar(dto);

        return ResponseEntity.status(201).body(tipo);
    }

    @GetMapping
    public ResponseEntity<List<TipoQuartoResponseDTO>> listar() {

        var response = service.listar()
                .stream()
                .map(TipoQuartoMapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }
}