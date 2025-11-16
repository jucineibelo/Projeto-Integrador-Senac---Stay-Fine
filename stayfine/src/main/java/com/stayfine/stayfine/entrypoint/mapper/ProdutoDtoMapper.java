package com.stayfine.stayfine.entrypoint.mapper;

import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.entrypoint.dto.ProdutoRequest;
import com.stayfine.stayfine.entrypoint.dto.ProdutoResponse;

public class ProdutoDtoMapper {

    public static Produto requestToDomain(ProdutoRequest request) {
        return new Produto(request.descricao(), request.preco());
    }

    public static ProdutoResponse domainToResponse(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getDataCadastro(),
                produto.getDataAtualizacao(),
                produto.getStatus());
    }

}
