package com.stayfine.stayfine.entrypoint.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

public record AgendamentoResponse(
        Long id,
        OffsetDateTime dataCadastro,
        String cliente,
        String pagamento,
        String profissional,
        List<String> produtos,
        LocalDateTime dataAgendamento

) {
}