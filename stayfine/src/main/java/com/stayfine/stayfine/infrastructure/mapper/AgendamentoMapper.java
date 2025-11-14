package com.stayfine.stayfine.infrastructure.mapper;

import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.infrastructure.database.entity.AgendamentoDBEntity;

public class AgendamentoMapper {

    public static AgendamentoDBEntity toDbEntity(Agendamento agendamento) {
        return new AgendamentoDBEntity(
                agendamento.getId(),
                agendamento.getDataCadastro(),
                agendamento.getDataAgendamento(),
                agendamento.getStatus(),
                agendamento.getPessoa(),
                agendamento.getPagamento(),
                agendamento.getProfissional(),
                agendamento.getProdutos(),
                agendamento.getDataAgendamento()
        );
    }

    public static Agendamento toDomain(AgendamentoDBEntity entity){
        return new Agendamento(
                entity.getId(),
                entity.getDataCadastro(),
                entity.getDataAgendamento(),
                entity.getStatus(),
                entity.getCliente(),
                entity.getPagamento(),
                entity.getProfissional(),
                entity.getProdutos(),
                entity.getDataAgendamento()
        );
    }
}
