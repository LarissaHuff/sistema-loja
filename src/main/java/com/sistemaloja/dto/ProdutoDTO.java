package com.sistemaloja.dto;

public record ProdutoDTO(String nome,
                         int quantidadeMinima,
                         int preco,
                         String descricao,
                         int quantidade) {

    public ProdutoDTO(String nome, int quantidadeMinima, int preco, String descricao, int quantidade) {
        this.nome = nome;
        this.quantidadeMinima = quantidadeMinima;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
}
