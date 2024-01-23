package com.sistemaloja.controller;

import com.sistemaloja.dto.ProdutoDTO;
import com.sistemaloja.dto.ProdutoViewDTO;
import com.sistemaloja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public void cadastrar(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.cadastrar(produtoDTO);
    }

    @DeleteMapping("/{id}")
    public void deletarById(@PathVariable Long id) {
        produtoService.deletarById(id);
    }

    @GetMapping("/{id}")
    public ProdutoViewDTO findById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @GetMapping
    public List<ProdutoViewDTO> findAll() {
        return produtoService.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        produtoService.update(id, produtoDTO);
    }

}
