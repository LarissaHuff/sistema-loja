package com.sistemaloja.controller;

import com.sistemaloja.dto.CompraDTO;
import com.sistemaloja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {
    @Autowired
    CompraService compraService;

    @PostMapping("/cliente/{idCliente}")
    public void comprar(@PathVariable Long idCliente, @RequestBody CompraDTO compraDTO) {
        compraService.comprar(idCliente, compraDTO);


    }
}
