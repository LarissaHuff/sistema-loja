package com.sistemaloja.dto;

import com.sistemaloja.enumeration.TipoDesconto;

import java.time.LocalDate;

public record CupomDTO(Integer valor,
                       String codigo,
                       TipoDesconto tipoDesconto,
                       Integer valorMinimoDaCompra,
                       Integer quantidade,
                       LocalDate dataExpiracao,
                       Boolean ativo
                        ){

}
