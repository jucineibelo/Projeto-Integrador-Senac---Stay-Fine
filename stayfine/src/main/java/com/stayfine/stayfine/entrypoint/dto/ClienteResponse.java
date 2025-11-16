package com.stayfine.stayfine.entrypoint.dto;

import java.time.OffsetDateTime;

public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        OffsetDateTime dataCadastro,
        OffsetDateTime dataAtualizacao,
        String status
) {

}

