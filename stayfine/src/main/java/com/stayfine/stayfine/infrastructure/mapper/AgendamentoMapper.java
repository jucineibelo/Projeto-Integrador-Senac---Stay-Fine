package com.stayfine.stayfine.infrastructure.mapper;

import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.infrastructure.database.entity.AgendamentoDBEntity;

public class AgendamentoMapper {

    public static AgendamentoDBEntity toDbEntity(Agendamento agendamento) {
        return new AgendamentoDBEntity();
    }

    public static Agendamento toDomain(AgendamentoDBEntity entity){
        return new Agendamento();
    }
}
