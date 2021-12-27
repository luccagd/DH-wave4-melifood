package com.example.melifood.repository;

import com.example.melifood.entity.Prato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PratoRepository {
    private static List<Prato> pratos = new ArrayList<>();

    public List<Prato> getPratos() {
        return new ArrayList<>(pratos);
    }

    public Prato getPratoPorId(Integer id) {
        for (Prato prato : pratos) {
            if (prato.getId() == id) {
                return prato;
            }
        }

        return null;
    }

    public Prato adicionaPrato(Prato prato) {
        pratos.add(prato);

        return prato;
    }
}
