package com.example.melifood.controller;

import com.example.melifood.dto.PedidoDTO;
import com.example.melifood.entity.Pedido;
import com.example.melifood.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> getPedidos() {
        List<PedidoDTO> pedidosDTO = PedidoDTO.entityListToDTO(service.getPedidos());

        return ResponseEntity.ok(pedidosDTO);
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> adicionaPedido(@RequestBody PedidoDTO pedidoDTO, UriComponentsBuilder uriComponentsBuilder) {
        Pedido pedido = service.adicionaPedido(PedidoDTO.toEntity(pedidoDTO));

        URI uri = uriComponentsBuilder.path("pedido/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(PedidoDTO.toDTO(pedido));
    }

}
