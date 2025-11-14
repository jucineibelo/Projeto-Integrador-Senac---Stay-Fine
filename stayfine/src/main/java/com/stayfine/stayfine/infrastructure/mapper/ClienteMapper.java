package com.stayfine.stayfine.infrastructure.mapper;

import com.stayfine.stayfine.core.domain.model.Cliente;
import com.stayfine.stayfine.infrastructure.database.entity.ClienteDBEntity;

public class ClienteMapper {

    public static ClienteDBEntity toDbEntity(Cliente cliente) {
        return new ClienteDBEntity(
                cliente.getId(),
                cliente.getNome(),
                cliente.getStatus(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getDataCadastro(),
                cliente.getDataAtualizacao(),
                cliente.getUsername(),
                cliente.getPassword());
    }

    public static Cliente toDomain(ClienteDBEntity entity) {
        return new Cliente(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTelefone(),
                entity.getDataCadastro(),
                entity.getDataAtualizacao(),
                entity.getStatus(),
                entity.getUsername(),
                entity.getPassword());
    }
}
