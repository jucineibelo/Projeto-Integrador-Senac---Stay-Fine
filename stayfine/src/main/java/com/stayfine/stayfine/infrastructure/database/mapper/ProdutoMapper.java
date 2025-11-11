package com.stayfine.stayfine.infrastructure.database.mapper;

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

    public static Produto toDomain(ProdutoDBEntity produtoDBEntity) {
        return new Produto(
                produtoDBEntity.getId(),
                produtoDBEntity.getDescricao(),
                produtoDBEntity.getPreco(),
                produtoDBEntity.getDataCadastro(),
                produtoDBEntity.getDataAtualizacao(),
                produtoDBEntity.getStatus());
    }
}
