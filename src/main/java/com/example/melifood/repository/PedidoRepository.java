package com.example.melifood.repository;

import com.example.melifood.entity.Pedido;
import com.example.melifood.entity.Prato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PedidoRepository {
    private static List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedidos() {
        return new ArrayList<>(pedidos);
    }

    public Pedido adicionaPedido(Pedido pedido) {
        pedidos.add(pedido);

        return pedido;
    }
}
