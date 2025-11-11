package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.gateway.ProdutoGateway;
import com.stayfine.stayfine.infrastructure.database.entity.ProdutoDBEntity;
import com.stayfine.stayfine.infrastructure.database.mapper.ProdutoMapper;
import com.stayfine.stayfine.infrastructure.database.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoPersistenceAdapter implements ProdutoGateway {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    private final Logger log = LoggerFactory.getLogger(ProdutoPersistenceAdapter.class);

    public ProdutoPersistenceAdapter(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Produto inserirProduto(Produto produto) {
        ProdutoDBEntity produtoDBEntity = repository.save(mapper.toDbEntity(produto));
        log.debug("Produto salvo id={}", produtoDBEntity.getId());
        return mapper.toDomain(produtoDBEntity);
    }

    @Override
    public Produto buscarProduto(Long id) {

        ProdutoDBEntity produtoDB = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(id + " Produto não encontrado na base de dados"));

        return mapper.toDomain(produtoDB);
    }

    @Override
    public List<Produto> listarProdutos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }


    @Override
    public Produto atualizarProduto(Long id, Produto produto) {
        ProdutoDBEntity produtoExistente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado para atualização."));

        ProdutoDBEntity produtoAtualizado = mapper.toDbEntity(produto);
        produtoAtualizado.setId(produtoExistente.getId());
        ProdutoDBEntity salvo = repository.save(produtoAtualizado);
        log.debug("Profissional atualizado id={}", salvo.getId());
        return mapper.toDomain(salvo);
    }

    @Override
    public void excluirProduto(Long id) {
        ProdutoDBEntity produtoExistente = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado para exclusão."));

        repository.save(produtoExistente);
        log.debug("Produto marcado como EXCLUIDO id={}", id);
    }
}
