package com.stayfine.stayfine.entrypoint.mapper;

import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.entrypoint.dto.ProfissionalRequest;
import com.stayfine.stayfine.entrypoint.dto.ProfissionalResponse;

public class ProfissionalDtoMapper {

    public static ProfissionalResponse toResponse(Profissional profissional) {
        return new ProfissionalResponse(
                profissional.getId(),
                profissional.getNome(),
                profissional.getStatus(),
                profissional.getDataCadastro(),
                profissional.getDataAtualizacao()
        );
    }

    public static Profissional requestToDomain(ProfissionalRequest request) {
        return new Profissional(request.nome());
    }
}