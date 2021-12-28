package com.example.melifood.dto;

import com.example.melifood.entity.Pedido;
import com.example.melifood.entity.Prato;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PedidoDTO {
    private static int count = 0;

    private Integer id;

    private Integer idMesa;

    private List<PratoDTO> pratosSolicitados;

    private BigDecimal valorTotal;

    public PedidoDTO() {
        count++;

        this.id = count;
    }

    public PedidoDTO(Integer id, Integer idMesa, List<PratoDTO> pratosSolicitados, BigDecimal valorTotal) {
        this.id = id;
        this.idMesa = idMesa;
        this.pratosSolicitados = pratosSolicitados;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdMesa() {
        return idMesa;
    }

    public List<PratoDTO> getPratosSolicitados() {
        return new ArrayList<>(pratosSolicitados);
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public static Pedido toEntity(PedidoDTO pedidoDTO) {
        List<Prato> pratos = new ArrayList<>();
        for (PratoDTO pratoDTO : pedidoDTO.getPratosSolicitados()) {
            pratos.add(PratoDTO.toEntity(pratoDTO));
        }

        return new Pedido(pedidoDTO.getId(), pedidoDTO.getIdMesa(), pratos, pedidoDTO.getValorTotal());
    }

    public static PedidoDTO toDTO(Pedido pedido) {
        List<PratoDTO> pratosDTO = new ArrayList<>();
        for (Prato prato : pedido.getPratosSolicitados()) {
            pratosDTO.add(PratoDTO.toDTO(prato));
        }

        return new PedidoDTO(pedido.getId(), pedido.getIdMesa(), pratosDTO, pedido.getValorTotal());
    }

    public static List<PedidoDTO> entityListToDTO(List<Pedido> pedidos) {
        List<PedidoDTO> pedidosDTO = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            pedidosDTO.add(toDTO(pedido));
        }

        return pedidosDTO;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "id=" + id +
                ", idMesa=" + idMesa +
                ", pratosSolicitados=" + pratosSolicitados +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
