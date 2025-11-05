package com.stayfine.stayfine.infrastructure.database.mapper;

import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.infrastructure.database.entity.ProfissionalDBEntity;

public class ProfissionalMapper {

    public static ProfissionalDBEntity toDbEntity(Profissional domain) {
        return new ProfissionalDBEntity(
                domain.getId(),
                domain.getNome(),
                domain.getStatus(),
                domain.getDataCadastro(),
                domain.getDataAtualizacao()
        );
    }

    public static Profissional toDomain(ProfissionalDBEntity db) {
        return new Profissional(
                db.getId(),
                db.getNome(),
                db.getStatus(),
                db.getDataRegistro(),
                db.getDataAtualizacao()
        );
    }
}
