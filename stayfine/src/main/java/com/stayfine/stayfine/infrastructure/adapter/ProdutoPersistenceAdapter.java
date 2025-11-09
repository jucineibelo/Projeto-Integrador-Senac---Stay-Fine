package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.gateway.ProdutoGateway;
import com.stayfine.stayfine.infrastructure.database.entity.ProdutoDBEntity;
import com.stayfine.stayfine.infrastructure.database.mapper.ProdutoMapper;
import com.stayfine.stayfine.infrastructure.database.repository.ProdutoRepository;

import java.util.List;

import static com.stayfine.stayfine.infrastructure.database.mapper.ProfissionalMapper.toDomain;

public class ProdutoPersistenceAdapter implements ProdutoGateway {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoPersistenceAdapter(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Produto inserirProduto(Produto produto) {
        ProdutoDBEntity produtoDBEntity = repository.save(mapper.toDbEntity(produto));
        return mapper.toDomain(produtoDBEntity);
    }

    @Override
    public Produto buscarProduto(Long id) {
        return null;
    }

    @Override
    public List<Produto> listarProdutos() {
        return List.of();
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produto) {
        return null;
    }

    @Override
    public void excluirProduto(Long id) {

    }
}
