package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.gateway.ProdutoGateway;
import com.stayfine.stayfine.infrastructure.database.entity.ProdutoDBEntity;
import com.stayfine.stayfine.infrastructure.mapper.ProdutoMapper;
import com.stayfine.stayfine.infrastructure.database.repository.ProdutoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.stayfine.stayfine.infrastructure.mapper.ProdutoMapper.toDbEntity;
import static com.stayfine.stayfine.infrastructure.mapper.ProdutoMapper.toDomain;

@Service
public class ProdutoPersistenceAdapter implements ProdutoGateway {

    private final ProdutoRepository repository;
    private final Logger log = LoggerFactory.getLogger(ProdutoPersistenceAdapter.class);

    public ProdutoPersistenceAdapter(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Produto inserirProduto(Produto produto) {
        ProdutoDBEntity produtoDBEntity = repository.save(toDbEntity(produto));
        log.debug("Produto salvo id={}", produtoDBEntity.getId());
        return toDomain(produtoDBEntity);
    }

    @Override
    public Produto buscarProduto(Long id) {

        ProdutoDBEntity produtoDB = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " Produto não encontrado na base de dados"));

        return toDomain(produtoDB);
    }

    @Override
    public List<Produto> listarProdutos() {
        return repository.findAll()
                .stream()
                .map(ProdutoMapper::toDomain)
                .toList();
    }


    @Override
    @Transactional
    public Produto atualizarProduto(Produto produto) {
        ProdutoDBEntity salvo = repository.save(toDbEntity(produto));
        log.debug("Profissional atualizado id={}", salvo.getId());
        return toDomain(salvo);
    }

    @Override
    @Transactional
    public void excluirProduto(Produto produto) {
        repository.save(toDbEntity(produto));
        log.debug("Produto marcado como EXCLUIDO id={}", produto.getId());
    }
}
