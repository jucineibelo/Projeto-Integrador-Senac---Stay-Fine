package com.stayfine.stayfine.entrypoint.dto;

public record PagamentoRequest(
        String descricao,
        String tipo
) {
}