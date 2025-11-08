package com.stayfine.stayfine.core.usecase;

import com.stayfine.stayfine.core.domain.model.Produto;

import java.util.List;

public interface ProdutoUseCase {
    Produto inserirProduto(Produto produto);

    Produto buscarProduto(Long id);

    List<Produto> listarProdutos();

    Produto atualizarProduto(Long id, Produto produto);

    void excluirProduto();
}
