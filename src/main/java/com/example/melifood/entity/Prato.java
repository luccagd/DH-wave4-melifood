package com.example.melifood.entity;

import java.math.BigDecimal;

public class Prato {
    private static int count = 0;

    private Integer id;

    private BigDecimal preco;

    private String descricao;

    private Double quantidade;

    public Prato(BigDecimal preco, String descricao, Double quantidade) {
        count++;

        this.id = count;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
