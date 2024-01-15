package com.sistemaloja.controller;

import com.sistemaloja.dto.ProdutoDTO;
import com.sistemaloja.dto.ProdutoViewDTO;
import com.sistemaloja.model.Produto;
import com.sistemaloja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public void cadastrar(@RequestBody ProdutoDTO produtoDTO){
        Produto produto = new Produto();

        produto.setDescricao(produtoDTO.descricao());
        produto.setPreco(produtoDTO.preco());
        produto.setQuantidade(produtoDTO.quantidade());
        produto.setQuantidadeMinima(produtoDTO.quantidadeMinima());
        produto.setNome(produtoDTO.nome());

        produtoRepository.save(produto);

    }
    @DeleteMapping("/{id}")
    public void deletarById(@PathVariable Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produtoRepository.delete(produto);

    }

    @GetMapping("/{id}")
    public ProdutoViewDTO findById(@PathVariable Long id){
     return new ProdutoViewDTO(produtoRepository.findById(id).orElseThrow());

    }

    @GetMapping
    public List<ProdutoViewDTO> findAll(){
     List<Produto>produtoList = produtoRepository.findAll();

     return produtoList.stream()
             .map(ProdutoViewDTO::new)
             .toList();
    }
}
