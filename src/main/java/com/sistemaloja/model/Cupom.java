package com.sistemaloja.model;

import com.sistemaloja.enumeration.TipoDesconto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Table
@Entity
public class Cupom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer valor;
    private String codigo;
    @Enumerated(EnumType.STRING)
    private TipoDesconto tipoDesconto;
    private Integer valorMinimoDaCompra;
    private Integer quantidade;
    private LocalDate dataExpiracao;
    private Boolean ativo;


}
