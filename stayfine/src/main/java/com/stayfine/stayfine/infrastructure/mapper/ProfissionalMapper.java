package com.stayfine.stayfine.infrastructure.mapper;

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

    public static Profissional toDomain(ProfissionalDBEntity entity) {
        return new Profissional(
                entity.getId(),
                entity.getNome(),
                entity.getStatus(),
                entity.getDataRegistro(),
                entity.getDataAtualizacao()
        );
    }
}
