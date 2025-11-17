package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.core.gateway.PagamentoGateway;
import com.stayfine.stayfine.infrastructure.database.entity.PagamentoDBEntity;
import com.stayfine.stayfine.infrastructure.database.repository.PagamentoRepository;
import com.stayfine.stayfine.infrastructure.mapper.PagamentoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.stayfine.stayfine.infrastructure.mapper.PagamentoMapper.toDbEntity;
import static com.stayfine.stayfine.infrastructure.mapper.PagamentoMapper.toDomain;

@Service
public class PagamentoPersistenceAdapter implements PagamentoGateway {

    private static final Logger log = LoggerFactory.getLogger(PagamentoPersistenceAdapter.class);
    private final PagamentoRepository repository;

    public PagamentoPersistenceAdapter(PagamentoRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Pagamento inserirPagamento(Pagamento pagamento) {
        PagamentoDBEntity pagamentoDB = repository.save(toDbEntity(pagamento));
        log.debug("Inserindo pagamento: {}", pagamento);
        return toDomain(pagamentoDB);
    }

    @Override
    public Pagamento buscarPagamento(Long id) {

        if (!repository.existsByIdAndStatus(id, "ATIVO")) {
            throw new EntityNotFoundException(id + " Pagamento não encontrado ou excluído na base de dados");
        }

        return toDomain(repository.findById(id).orElseThrow());
    }

    @Override
    public List<Pagamento> listarPagamentos() {
        return repository.findAll()
                .stream()
                .map(PagamentoMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public Pagamento atualizarPagamento(Pagamento pagamento) {
        log.debug("Atualizando pagamento: {}", pagamento);
        return toDomain(repository.save(toDbEntity(pagamento)));
    }

    @Override
    public void excluirPagamento(Pagamento pagamento) {
        repository.save(toDbEntity(pagamento));
        log.debug("Pagamento excluído id={}", pagamento.getId());
    }
}
