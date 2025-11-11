package com.stayfine.stayfine.infrastructure.database.mapper;

import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.infrastructure.database.entity.PagamentoDBEntity;
import com.stayfine.stayfine.infrastructure.database.entity.ProdutoDBEntity;

public class PagamentoMapper {

    public PagamentoDBEntity toDbEntity(Pagamento pagamento) {
        return new PagamentoDBEntity(
                pagamento.getId(),
                pagamento.getDescricao(),
                pagamento.getDataCadastro(),
                pagamento.getDataAtualizacao(),
                pagamento.getTipo(),
                pagamento.getStatus());
    }

    public Pagamento toDomain(PagamentoDBEntity pagamentoDBEntity) {
        return new Pagamento(

                pagamentoDBEntity.getId(),
                pagamentoDBEntity.getDescricao(),
                pagamentoDBEntity.getDataCadastro(),
                pagamentoDBEntity.getDataAtualizacao(),
                pagamentoDBEntity.getTipo(),
                pagamentoDBEntity.getStatus());
    }
}