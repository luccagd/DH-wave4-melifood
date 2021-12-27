package com.example.melifood.service;

import com.example.melifood.entity.Prato;
import com.example.melifood.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PratoService {

    @Autowired
    private PratoRepository repository;

    public List<Prato> getPratos() {
        return repository.getPratos();
    }

    public Prato adicionaPrato(Prato prato) {
        return repository.adicionaPrato(prato);
    }
}
