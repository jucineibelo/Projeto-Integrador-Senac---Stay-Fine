package com.stayfine.stayfine.infrastructure.mapper;

import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.infrastructure.database.entity.PagamentoDBEntity;
import com.stayfine.stayfine.infrastructure.database.entity.ProdutoDBEntity;

public class PagamentoMapper {

    public static PagamentoDBEntity toDbEntity(Pagamento pagamento) {
        return new PagamentoDBEntity(
                pagamento.getId(),
                pagamento.getDescricao(),
                pagamento.getDataCadastro(),
                pagamento.getDataAtualizacao(),
                pagamento.getStatus(),
                pagamento.getTipo());
    }

    public static Pagamento toDomain(PagamentoDBEntity entity) {
        return new Pagamento(

                entity.getId(),
                entity.getDescricao(),
                entity.getDataCadastro(),
                entity.getDataAtualizacao(),
                entity.getStatus(),
                entity.getTipo());
    }
}