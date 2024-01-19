package com.sistemaloja.service;

import com.sistemaloja.dto.FormaPagamentoDTO;
import com.sistemaloja.model.CestoCompras;
import com.sistemaloja.model.Cliente;
import com.sistemaloja.model.Compra;
import com.sistemaloja.model.DetalheCompra;
import com.sistemaloja.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CestoComprasService cestoComprasService;


    public void comprar(Long idCliente, FormaPagamentoDTO dtoFormaPagamento) {
        Cliente cliente = clienteService.findById(idCliente);

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setTipoPagamento(dtoFormaPagamento.tipoPagamento());
        compra.setValorTotal(cliente.valorTotal());
        List<DetalheCompra> cestoCompras = cliente.getCestoCompras().stream()
                .map(cestoCompra -> new DetalheCompra(cestoCompra.getProduto(),
                        compra, cestoCompra.getQuantidadeProduto()))
                .toList();

        compra.setDetalheCompraList(cestoCompras);

        compraRepository.save(compra);
        cestoComprasService.removerTodosItensDoCesto(cliente);
    }


}
