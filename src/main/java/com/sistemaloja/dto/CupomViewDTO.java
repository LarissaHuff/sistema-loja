package com.sistemaloja.dto;

import com.sistemaloja.enumeration.TipoDesconto;
import com.sistemaloja.model.Cupom;

import java.time.LocalDate;

public record CupomViewDTO(Integer valor,
                           String codigo,
                           TipoDesconto tipoDesconto,
                           Integer valorMinimoDaCompra,
                           Integer quantidade,
                           LocalDate dataExpiracao,
                           Boolean ativo) {
    public CupomViewDTO(Cupom cupom) {
        this(cupom.getValor(), cupom.getCodigo(), cupom.getTipoDesconto(), cupom.getValorMinimoDaCompra(),
                cupom.getQuantidade(), cupom.getDataExpiracao(), cupom.getAtivo());
    }
}

