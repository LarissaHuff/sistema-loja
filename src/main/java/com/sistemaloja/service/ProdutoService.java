package com.sistemaloja.service;

import com.sistemaloja.dto.ProdutoDTO;
import com.sistemaloja.dto.ProdutoViewDTO;
import com.sistemaloja.model.Produto;
import com.sistemaloja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public void cadastrar(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();

        produto.setDescricao(produtoDTO.descricao());
        produto.setPreco(produtoDTO.preco());
        produto.setQuantidade(produtoDTO.quantidade());
        produto.setQuantidadeMinima(produtoDTO.quantidadeMinima());
        produto.setNome(produtoDTO.nome());

        produtoRepository.save(produto);
    }

    public void deletarById(Long id) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produtoRepository.delete(produto);
    }

    public ProdutoViewDTO findById(Long id) {
        return new ProdutoViewDTO(produtoRepository.findById(id).orElseThrow());

    }

    public List<ProdutoViewDTO> findAll() {
        List<Produto> produtoList = produtoRepository.findAll();

        return produtoList.stream()
                .map(ProdutoViewDTO::new)
                .toList();
    }

    public void update(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produto.setNome(produtoDTO.nome());
        produto.setPreco(produtoDTO.preco());
        produto.setDescricao(produtoDTO.descricao());
        produto.setQuantidadeMinima(produtoDTO.quantidadeMinima());
        produto.setQuantidade(produtoDTO.quantidade());

        produtoRepository.save(produto);

    }
}
