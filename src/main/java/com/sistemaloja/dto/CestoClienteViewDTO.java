package com.sistemaloja.dto;

import java.util.List;

public record CestoClienteViewDTO(List<CestoDTO>cestoDTO,
                                  int valorTotal) {


}
