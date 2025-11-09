package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.enums.DomainStatus;
import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.exceptions.DomainException;
import com.stayfine.stayfine.core.gateway.ProdutoGateway;
import com.stayfine.stayfine.core.usecase.ProdutoUseCase;

import java.time.OffsetDateTime;
import java.util.List;

import static com.stayfine.stayfine.core.domain.enums.DomainStatus.EXCLUIDO;
import static com.stayfine.stayfine.core.util.DomainUtil.deveAtualizar;

public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoGateway gateway;

    public ProdutoUseCaseImpl(ProdutoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Produto inserirProduto(Produto produto) {
        if (produto == null) {
            throw new DomainException("Produto está vazio");
        }

        produto.setDataCadastro(OffsetDateTime.now());
        produto.setStatus(DomainStatus.ATIVO.name());
        return gateway.inserirProduto(produto);
    }

    @Override
    public Produto buscarProduto(Long id) {

        if (id == null) {
            throw new DomainException("O código do produto está vazio");
        }

        return gateway.buscarProduto(id);
    }

    @Override
    public List<Produto> listarProdutos() {
        return gateway.listarProdutos();
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produto) {

        if (id == null || produto == null) {
            throw new DomainException("Dados incompletos para atualizar registro");
        }

        Produto produtoExistente = buscarProduto(id);

        if (deveAtualizar(produto.getDescricao(), produtoExistente.getDescricao())) {
            produtoExistente.setDescricao(produto.getDescricao());
            produtoExistente.setDataAtualizacao(OffsetDateTime.now());
        }

        if (produto.getPreco() > 0 && produto.getPreco() != produtoExistente.getPreco()) {
            produtoExistente.setPreco(produto.getPreco());
            produtoExistente.setDataAtualizacao(OffsetDateTime.now());
        }

        return gateway.atualizarProduto(id, produtoExistente);
    }

    @Override
    public void excluirProduto(Long id) {

        if (id == null) {
            throw new DomainException("O código está vazio");
        }

        Produto produto = buscarProduto(id);
        produto.setStatus(EXCLUIDO.name());
        produto.setDataAtualizacao(OffsetDateTime.now());
        gateway.excluirProduto(produto.getId());
    }
}
