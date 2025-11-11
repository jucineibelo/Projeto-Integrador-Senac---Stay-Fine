package com.stayfine.stayfine.infrastructure.database.mapper;

import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.infrastructure.database.entity.ProfissionalDBEntity;

public class ProfissionalMapper {

    public static ProfissionalDBEntity toDbEntity(Profissional profissional) {
        return new ProfissionalDBEntity(
                profissional.getId(),
                profissional.getNome(),
                profissional.getStatus(),
                profissional.getDataCadastro(),
                profissional.getDataAtualizacao()
        );
    }

    public static Profissional toDomain(ProfissionalDBEntity profissionalDBEntity) {
        return new Profissional(
                profissionalDBEntity.getId(),
                profissionalDBEntity.getNome(),
                profissionalDBEntity.getStatus(),
                profissionalDBEntity.getDataRegistro(),
                profissionalDBEntity.getDataAtualizacao()
        );
    }
}
