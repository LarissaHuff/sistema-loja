package com.sistemaloja.dto;

import com.sistemaloja.enumeration.TipoDocumento;
import com.sistemaloja.model.Cliente;

import java.time.LocalDate;

public record ClienteViewDTO(String nome,
                             String numeroDocumento,
                             TipoDocumento tipoDocumento,
                             LocalDate dataNascimento) {
    public ClienteViewDTO(Cliente cliente) {
        this(cliente.getNome(), cliente.getNumeroDocumento(), cliente.getTipoDocumento(), cliente.getDataNascimento());
    }
}
