package com.stayfine.stayfine.entrypoint.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

public record AgendamentoRequestUpdate(
        Long pagamentoId,
        Long profissionalId,
        LocalDateTime dataAgendamento
) {
}
