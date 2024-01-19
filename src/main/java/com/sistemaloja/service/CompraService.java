package com.sistemaloja.service;

import com.sistemaloja.dto.FormaPagamentoDTO;
import com.sistemaloja.model.Cliente;
import com.sistemaloja.model.Compra;
import com.sistemaloja.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ClienteService clienteService;

    public void comprar(Long idCliente, FormaPagamentoDTO dtoFormaPagamento) {
        Cliente cliente = clienteService.findById(idCliente);

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setTipoPagamento(dtoFormaPagamento.tipoPagamento());
        compra.setValorTotal(cliente.valorTotal());

        compraRepository.save(compra);
    }
}
