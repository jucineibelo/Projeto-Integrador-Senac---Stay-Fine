package com.stayfine.stayfine.entrypoint.mapper;

import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.entrypoint.dto.PagamentoRequest;
import com.stayfine.stayfine.entrypoint.dto.PagamentoResponse;

public class PagamentoDtoMapper {

    public static PagamentoResponse toResponse(Pagamento pagamento) {
        return new PagamentoResponse(
                pagamento.getId(),
                pagamento.getDescricao(),
                pagamento.getDataCadastro(),
                pagamento.getDataAtualizacao(),
                pagamento.getStatus(),
                pagamento.getTipo()
        );
    }

    public  static Pagamento toDomain(PagamentoRequest request) {
        return new Pagamento(
                request.descricao(),
                request.tipo()
        );
    }
}
