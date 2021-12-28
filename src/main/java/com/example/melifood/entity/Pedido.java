package com.example.melifood.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer id;

    private Integer idMesa;

    private List<Prato> pratosSolicitados;

    private BigDecimal valorTotal;

    public Pedido(Integer id, Integer idMesa, List<Prato> pratosSolicitados, BigDecimal valorTotal) {
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

    public List<Prato> getPratosSolicitados() {
        return new ArrayList<>(pratosSolicitados);
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idMesa=" + idMesa +
                ", pratosSolicitados=" + pratosSolicitados +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
