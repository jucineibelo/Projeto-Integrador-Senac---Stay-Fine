package com.stayfine.stayfine.entrypoint.dto;

import java.time.OffsetDateTime;
import java.util.List;

public record AgendamentoRequest(
        Long clienteId,
        Long pagamentoId,
        Long profissionalId,
        List<Long> produtosIds,
        OffsetDateTime dataAgendamento
) {
}
