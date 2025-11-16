package com.stayfine.stayfine.entrypoint.mapper;

import com.stayfine.stayfine.core.domain.model.Cliente;
import com.stayfine.stayfine.entrypoint.dto.ClienteRequest;
import com.stayfine.stayfine.entrypoint.dto.ClienteResponse;

public class ClienteDtoMapper {

    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getDataCadastro(),
                cliente.getDataAtualizacao(),
                cliente.getStatus()
        );
    }

    public static Cliente toDomain(ClienteRequest request) {
        return new Cliente(
                request.nome(),
                request.email(),
                request.telefone(),
                request.username(),
                request.password()
        );
    }
}
