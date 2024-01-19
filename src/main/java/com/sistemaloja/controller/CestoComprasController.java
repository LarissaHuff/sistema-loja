package com.sistemaloja.controller;

import com.sistemaloja.dto.CestoClienteViewDTO;
import com.sistemaloja.dto.CestoDTO;
import com.sistemaloja.service.CestoComprasService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping
    public CestoClienteViewDTO getCesto(@PathVariable Long idCliente) {
        return cestoComprasService.getCesto(idCliente);
    }

    @PutMapping
    public void alterarQuantidadeItem(@PathVariable Long idCliente, @RequestBody CestoDTO cestoDTO) {
        cestoComprasService.alterarQuantidadeItem(idCliente, cestoDTO.quantidadeDoProduto(), cestoDTO.idProduto());
    }
}

