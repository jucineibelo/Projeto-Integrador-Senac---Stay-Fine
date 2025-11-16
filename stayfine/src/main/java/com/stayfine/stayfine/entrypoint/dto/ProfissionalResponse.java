package com.stayfine.stayfine.entrypoint.dto;

import java.time.OffsetDateTime;

public record ProfissionalResponse(
        Long id,
        String nome,
        String status,
        OffsetDateTime dataRegistro,
        OffsetDateTime dataAtualizacao
) {
}
