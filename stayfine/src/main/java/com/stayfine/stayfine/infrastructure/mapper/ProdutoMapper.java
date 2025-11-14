package com.stayfine.stayfine.infrastructure.mapper;

import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.infrastructure.database.entity.ProdutoDBEntity;

public class ProdutoMapper {

    public static ProdutoDBEntity toDbEntity(Produto produto) {
        return new ProdutoDBEntity(
                produto.getId(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getDataCadastro(),
                produto.getDataAtualizacao(),
                produto.getStatus());
    }

    public static Produto toDomain(ProdutoDBEntity entity) {
        return new Produto(
                entity.getId(),
                entity.getDescricao(),
                entity.getPreco(),
                entity.getDataCadastro(),
                entity.getDataAtualizacao(),
                entity.getStatus());
    }
}
