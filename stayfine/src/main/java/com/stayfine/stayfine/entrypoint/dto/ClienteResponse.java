package com.stayfine.stayfine.entrypoint.dto;

import java.time.OffsetDateTime;

public record ClienteResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        String username,
        String password,
        OffsetDateTime dataCadastro,
        OffsetDateTime dataAtualizacao,
        String status
) {

}

