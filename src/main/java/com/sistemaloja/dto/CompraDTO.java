package com.sistemaloja.dto;

import com.sistemaloja.enumeration.TipoPagamento;

public record CompraDTO(TipoPagamento tipoPagamento, String codigo) {
}
