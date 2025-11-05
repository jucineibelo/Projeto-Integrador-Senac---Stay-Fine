package com.stayfine.stayfine.entrypoint.mapper;

import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.entrypoint.dto.ProfissionalRequest;
import com.stayfine.stayfine.entrypoint.dto.ProfissionalResponse;

public class ProfissionalDtoMapper {

    public ProfissionalRequest domainToRequest(Profissional profissional) {
        return new ProfissionalRequest(
                profissional.getId(),
                profissional.getNome()
        );
    }

    public ProfissionalResponse domainToResponse(Profissional profissional) {
        return new ProfissionalResponse(
                profissional.getId(),
                profissional.getNome(),
                profissional.getStatus(),
                profissional.getDataCadastro(),
                profissional.getDataAtualizacao()
        );
    }

    public Profissional requestToDomain(ProfissionalRequest request) {
        return new Profissional(request.getNome());
    }

    public Profissional responseToDomain(ProfissionalResponse response) {
        return new Profissional(
                response.getId(),
                response.getNome(),
                response.getStatus(),
                response.getDataRegistro(),
                response.getDataAtualizacao()
        );
    }
}