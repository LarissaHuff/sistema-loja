package com.sistemaloja.service;

import com.sistemaloja.dto.CompraDTO;
import com.sistemaloja.enumeration.TipoDesconto;
import com.sistemaloja.model.Cliente;
import com.sistemaloja.model.Compra;
import com.sistemaloja.model.Cupom;
import com.sistemaloja.model.DetalheCompra;
import com.sistemaloja.repository.CompraRepository;
import com.sistemaloja.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CestoComprasService cestoComprasService;

    @Autowired
    private CupomService cupomService;


    public void comprar(Long idCliente, CompraDTO compraDTO) {
        Cliente cliente = clienteService.findById(idCliente);

        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setTipoPagamento(compraDTO.tipoPagamento());

        Integer valorFinal = cliente.valorTotal();

        if (compraDTO.codigo() != null) {
            Cupom cupom = cupomService.findByCodigo(compraDTO.codigo());
            compra.setCupom(cupom);
            valorFinal = cupomService.aplicarDesconto(cliente.valorTotal(), cupom);

        }

        compra.setValorTotal(valorFinal);
        compra.setDetalheCompraList(mapCestoParaDetalhe(cliente, compra));

        compraRepository.save(compra);
        cestoComprasService.removerTodosItensDoCesto(cliente);
    }

    private static List<DetalheCompra> mapCestoParaDetalhe(Cliente cliente, Compra compra) {
        return cliente.getCestoCompras().stream()
                .map(cestoCompra -> new DetalheCompra(cestoCompra.getProduto(),
                        compra, cestoCompra.getQuantidadeProduto()))
                .toList();
    }
}
