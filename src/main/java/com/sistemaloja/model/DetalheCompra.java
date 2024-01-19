package com.sistemaloja.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity
@Getter
@Setter
public class DetalheCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name= "id_compra")
    private Compra compra;

    private Integer quantidadeProduto;

    public DetalheCompra(Produto produto, Compra compra, Integer quantidadeProduto) {
        this.produto = produto;
        this.compra = compra;
        this.quantidadeProduto = quantidadeProduto;
    }
}
