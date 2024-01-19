package com.sistemaloja.model;

import com.sistemaloja.enumeration.TipoDocumento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String numeroDocumento;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "cliente")
    private List<CestoCompras> cestoCompras;


    public Integer valorTotal(){
        int sum = 0;
        for (int i = 0; i < this.cestoCompras.size(); i++) {

            CestoCompras cestoCompras = this.cestoCompras.get(i);
            int preco = cestoCompras.getProduto().getPreco();
            sum += preco;
        }
        return sum;
    }
}
