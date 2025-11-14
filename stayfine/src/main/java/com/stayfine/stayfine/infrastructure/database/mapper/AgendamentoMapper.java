package com.stayfine.stayfine.infrastructure.database.mapper;

import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.infrastructure.database.entity.AgendamentoDBEntity;

public class AgendamentoMapper {

    public static AgendamentoDBEntity toDbEntity(Agendamento domain) {
        return new AgendamentoDBEntity(
                domain.getId(),
                domain.getDataCadastro(),
                domain.getDataAgendamento(),
                domain.getStatus(),
                domain.getPessoa(),
                domain.getPagamento(),
                domain.getProfissional(),
                domain.getProdutos(),
                domain.getDataAgendamento()
        );
    }

    public static Agendamento toDomain(AgendamentoDBEntity db){
        return new Agendamento(
                db.getId(),
                db.getDataCadastro(),
                db.getDataAgendamento(),
                db.getStatus(),
                db.getPessoa(),
                db.getPagamento(),
                db.getProfissional(),
                db.getProdutos(),
                db.getDataAgendamento()
        );
    }
}
