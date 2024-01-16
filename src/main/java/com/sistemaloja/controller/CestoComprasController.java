package com.sistemaloja.controller;

import com.sistemaloja.dto.CestoDTO;
import com.sistemaloja.service.CestoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes/{idCliente}/cesto")
public class CestoComprasController {
    @Autowired
    CestoComprasService cestoComprasService;

    @PostMapping
    public void adicionarProdutos(@PathVariable Long idCliente, @RequestBody CestoDTO cestoDTO) {
        cestoComprasService.adicionarProdutos(cestoDTO.idProduto(), cestoDTO.quantidadeDoProduto(), idCliente);
    }

    @DeleteMapping
    public void removerItemDoCesto(@PathVariable Long idCliente, @RequestParam(required = false) Long idProduto) {
        if (idProduto == null) {
            cestoComprasService.removerTodosItensDoCesto(idCliente);
        } else {
            cestoComprasService.removerItemDoCesto(idCliente, idProduto);
        }
    }

    @PutMapping
    public void alterarQuantidadeItem(@PathVariable Long idCliente, @RequestBody CestoDTO cestoDTO) {
        cestoComprasService.alterarQuantidadeItem(idCliente, cestoDTO.quantidadeDoProduto(), cestoDTO.idProduto());
    }
}

