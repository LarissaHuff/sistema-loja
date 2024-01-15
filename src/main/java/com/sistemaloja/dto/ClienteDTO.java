package com.sistemaloja.dto;

import com.sistemaloja.enumeration.TipoDocumento;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record ClienteDTO(String nome,
                         String numeroDocumento,
                         TipoDocumento tipoDocumento,
                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                         LocalDate dataNascimento) {

    public ClienteDTO(String nome, String numeroDocumento, TipoDocumento tipoDocumento,
                      LocalDate dataNascimento) {
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.dataNascimento = dataNascimento;
    }
}
