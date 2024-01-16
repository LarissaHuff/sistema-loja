package com.sistemaloja.service;

import com.sistemaloja.controller.ClienteController;
import com.sistemaloja.model.CestoCompras;
import com.sistemaloja.model.Cliente;
import com.sistemaloja.model.Produto;
import com.sistemaloja.repository.CestoComprasRepository;
import com.sistemaloja.repository.ClienteRepository;
import com.sistemaloja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CestoComprasService {
    @Autowired
    CestoComprasRepository comprasRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    ClienteService clienteService;

    public void adicionarProdutos(Long idProduto, Integer quantidadeDoProduto, Long idCliente) {
        Produto produto = produtoRepository.findById(idProduto).orElseThrow();
        Cliente cliente = clienteService.findById(idCliente);

        CestoCompras cestoCompras = new CestoCompras();
        cestoCompras.setQuantidadeProduto(quantidadeDoProduto);
        cestoCompras.setProduto(produto);
        cestoCompras.setCliente(cliente);

        cliente.getCestoCompras().add(cestoCompras);

        comprasRepository.save(cestoCompras);
    }

    public void removerItemDoCesto(Long idCliente, Long idProduto) {
        List<CestoCompras> cesto = clienteService.findCesto(idCliente);

        cesto.stream()
                .filter(it -> Objects.equals(it.getProduto().getId(), idProduto))
                .findAny()
                .ifPresent(it -> comprasRepository.delete(it));

    }


    public void removerTodosItensDoCesto(Long idCliente) {
        List<CestoCompras> cesto = clienteService.findCesto(idCliente);
        comprasRepository.deleteAll(cesto);

    }

    public void alterarQuantidadeItem(Long idCliente, Integer quantidadeNova, Long idProduto) {
        List<CestoCompras> cesto = clienteService.findCesto(idCliente);

        cesto.stream()
                .filter(it -> Objects.equals(it.getProduto().getId(), idProduto))
                .findAny()
                .map(it -> setQuantidade(quantidadeNova, it))
                .ifPresent(it -> comprasRepository.save(it));

    }

    private static CestoCompras setQuantidade(Integer quantidadeNova, CestoCompras cesto) {
        cesto.setQuantidadeProduto(quantidadeNova);
        return cesto;
    }
}
