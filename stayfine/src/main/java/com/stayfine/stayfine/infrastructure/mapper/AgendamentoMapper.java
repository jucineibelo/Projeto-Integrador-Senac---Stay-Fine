package com.stayfine.stayfine.infrastructure.mapper;

import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.infrastructure.database.entity.AgendamentoDBEntity;

public class AgendamentoMapper {

    public static AgendamentoDBEntity toDbEntity(Agendamento agendamento) {

        return new AgendamentoDBEntity(
                agendamento.getId(),
                agendamento.getDataCadastro(),
                agendamento.getDataAtualizacao(),
                agendamento.getStatus(),
                ClienteMapper.toDbEntity(agendamento.getCliente()),
                ProfissionalMapper.toDbEntity(agendamento.getProfissional()),
                PagamentoMapper.toDbEntity(agendamento.getPagamento()),
                agendamento.getProdutos().stream()
                        .map(ProdutoMapper::toDbEntity)
                        .toList(),
                agendamento.getDataAgendamento(),
                agendamento.getValorTotal()
        );
    }

    public static Agendamento toDomain(AgendamentoDBEntity entity) {
        return new Agendamento(
                entity.getId(),
                entity.getDataCadastro(),
                entity.getDataAtualizacao(),
                entity.getStatus(),
                ClienteMapper.toDomain(entity.getCliente()),
                PagamentoMapper.toDomain(entity.getPagamento()),
                ProfissionalMapper.toDomain(entity.getProfissional()),
                entity.getProdutos().stream()
                        .map(ProdutoMapper::toDomain)
                        .toList(),
                entity.getDataAgendamento(),
                entity.getValorTotal()
        );
    }
}
