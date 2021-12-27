package com.example.melifood.controller;

import com.example.melifood.dto.PratoDTO;
import com.example.melifood.entity.Prato;
import com.example.melifood.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/prato")
public class PratoController {

    @Autowired
    private PratoService service;

    @GetMapping
    public ResponseEntity<List<PratoDTO>> getPratos() {
        List<PratoDTO> pratosDTO = PratoDTO.entityListToDTO(service.getPratos());

        return ResponseEntity.ok(pratosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PratoDTO> getPratoPorId(@PathVariable Integer id) {
        PratoDTO pratoDTO = PratoDTO.toDTO(service.getPratoPorId(id));

        return ResponseEntity.ok(pratoDTO);
    }

    @PostMapping
    public ResponseEntity<PratoDTO> adicionaPrato(@RequestBody PratoDTO pratoDTO, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println(pratoDTO);
        Prato prato = service.adicionaPrato(PratoDTO.toEntity(pratoDTO));


        URI uri = uriComponentsBuilder.path("prato/{id}").buildAndExpand(prato.getId()).toUri();
        return ResponseEntity.created(uri).body(PratoDTO.toDTO(prato));
    }
}
