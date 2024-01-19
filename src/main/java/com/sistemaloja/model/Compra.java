package com.sistemaloja.model;

import com.sistemaloja.enumeration.TipoPagamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    private int valorTotal;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetalheCompra> detalheCompraList;


}
