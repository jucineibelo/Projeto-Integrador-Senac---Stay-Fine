package com.stayfine.stayfine.infrastructure.dataprovider.mapper;

import com.stayfine.stayfine.core.domain.entity.Profissional;
import com.stayfine.stayfine.infrastructure.dataprovider.repository.ProfissionalDBEntity;

public class ProfissionalMapper {

    public static Profissional toDomain(ProfissionalDBEntity profissionalDB) {
        return new Profissional(
                profissionalDB.getId(),
                profissionalDB.getNome(),
                profissionalDB.getStatus(),
                profissionalDB.getDataAtualizacao(),
                profissionalDB.getDataRegistro());

    }

    public static ProfissionalDBEntity toDbEntity(Profissional profissional) {
        return new ProfissionalDBEntity(
                profissional.getId(),
                profissional.getNome(),
                profissional.getStatus(),
                profissional.getDataAtualizacao(),
                profissional.getDataAtualizacao()
        );
    }
}
