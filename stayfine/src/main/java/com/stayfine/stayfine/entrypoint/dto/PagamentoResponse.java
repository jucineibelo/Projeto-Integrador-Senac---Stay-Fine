package com.stayfine.stayfine.entrypoint.dto;

import java.time.OffsetDateTime;

public record PagamentoResponse(
        Long id,
        String descricao,
        OffsetDateTime dataCadastro,
        OffsetDateTime dataAtualizacao,
        String status,
        String tipo
) {
}
