package com.sistemaloja.dto;

import com.sistemaloja.model.Produto;

public record ProdutoViewDTO(String nome,
                             int preco,
                             int quantidadeMinima,
                             String descricao,
                             int quantidade) {
    public ProdutoViewDTO(Produto produto) {
        this(produto.getNome(), produto.getPreco(), produto.getQuantidadeMinima(), produto.getDescricao(), produto.getQuantidade());

    }
}


