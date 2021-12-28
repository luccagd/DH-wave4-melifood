package com.example.melifood.service;

import com.example.melifood.entity.Pedido;
import com.example.melifood.entity.Prato;
import com.example.melifood.repository.PedidoRepository;
import com.example.melifood.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PratoRepository pratoRepository;

    public List<Pedido> getPedidos() {
        return pedidoRepository.getPedidos();
    }

    public Pedido adicionaPedido(Pedido pedido) {
        adicionarPratosAoPedido(pedido);
        return pedidoRepository.adicionaPedido(pedido);
    }

    private void adicionarPratosAoPedido(Pedido pedido) {
        for (Prato prato : pedido.getPratosSolicitados()) {
            Prato aux = pratoRepository.getPratoPorId(prato.getId());

            prato.setPreco(aux.getPreco());
            prato.setDescricao(aux.getDescricao());
            prato.setQuantidade(aux.getQuantidade());
        }
    }
}
