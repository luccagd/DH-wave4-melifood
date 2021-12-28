package com.example.melifood.dto;

import com.example.melifood.entity.Prato;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PratoDTO {
    private static int count = 0;

    private Integer id;

    private BigDecimal preco;

    private String descricao;

    private Double quantidade;

    public PratoDTO() {
        count++;

        this.id = count;
    }

    public PratoDTO(Integer id, BigDecimal preco, String descricao, Double quantidade) {
        this.id = id;
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

    public static Prato toEntity(PratoDTO pratoDTO) {
        return new Prato(pratoDTO.getId(), pratoDTO.getPreco(), pratoDTO.getDescricao(), pratoDTO.getQuantidade());
    }

    public static PratoDTO toDTO(Prato prato) {
        return new PratoDTO(prato.getId(), prato.getPreco(), prato.getDescricao(), prato.getQuantidade());
    }

    public static List<PratoDTO> entityListToDTO(List<Prato> pratos) {
        List<PratoDTO> pratosDTO = new ArrayList<>();
        for (Prato prato : pratos) {
            pratosDTO.add(toDTO(prato));
        }

        return pratosDTO;
    }

    @Override
    public String toString() {
        return "PratoDTO{" +
                "id=" + id +
                ", preco=" + preco +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
