package com.stayfine.stayfine.infrastructure.dataprovider.mapper;

import com.stayfine.stayfine.core.domain.entity.Profissional;
import com.stayfine.stayfine.infrastructure.dataprovider.repository.ProfissionalDBEntity;

public class ProfissionalMapper {

    public static ProfissionalDBEntity toDbEntity(Profissional domain) {
        return new ProfissionalDBEntity(
                domain.getId(),
                domain.getNome(),
                domain.getStatus(),
                domain.getDataRegistro(),
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
