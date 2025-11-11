package com.stayfine.stayfine.entrypoint.mapper;

import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.entrypoint.dto.ProfissionalRequest;
import com.stayfine.stayfine.entrypoint.dto.ProfissionalResponse;

public class ProfissionalDtoMapper {

    public static ProfissionalRequest domainToRequest(Profissional profissional) {
        return new ProfissionalRequest(
                profissional.getId(),
                profissional.getNome()
        );
    }

    public static ProfissionalResponse domainToResponse(Profissional profissional) {
        return new ProfissionalResponse(
                profissional.getId(),
                profissional.getNome(),
                profissional.getStatus(),
                profissional.getDataCadastro(),
                profissional.getDataAtualizacao()
        );
    }

    public static Profissional requestToDomain(ProfissionalRequest request) {
        return new Profissional(request.getNome());
    }

    public static Profissional responseToDomain(ProfissionalResponse response) {
        return new Profissional(
                response.getId(),
                response.getNome(),
                response.getStatus(),
                response.getDataRegistro(),
                response.getDataAtualizacao()
        );
    }
}