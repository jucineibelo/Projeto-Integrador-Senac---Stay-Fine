package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.gateway.AgendamentoGateway;
import com.stayfine.stayfine.infrastructure.database.entity.AgendamentoDBEntity;
import com.stayfine.stayfine.infrastructure.database.repository.*;
import com.stayfine.stayfine.infrastructure.mapper.AgendamentoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.stayfine.stayfine.infrastructure.mapper.AgendamentoMapper.toDbEntity;
import static com.stayfine.stayfine.infrastructure.mapper.AgendamentoMapper.toDomain;

@Service
public class AgendamentoPersistenceAdapter implements AgendamentoGateway {

    private final String STATUS_ATIVO = "ATIVO";

    private final AgendamentoRepository repository;
    private final ProfissionalRepository profissionalRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final PagamentoRepository pagamentoRepository;

    public AgendamentoPersistenceAdapter(AgendamentoRepository repository, ProfissionalRepository profissionalRepository,
                                         ClienteRepository clienteRepository, ProdutoRepository produtoRepository,
                                         PagamentoRepository pagamentoRepository) {
        this.repository = repository;
        this.profissionalRepository = profissionalRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public Agendamento inserirAgendamento(Agendamento agendamento) {

        esseRegistroEstaAtivo(clienteRepository.existsByIdAndStatus(agendamento.getCliente().getId(), STATUS_ATIVO),
                "Cliente", agendamento.getCliente().getId());

        esseRegistroEstaAtivo(pagamentoRepository.existsByIdAndStatus(agendamento.getPagamento().getId(), STATUS_ATIVO),
                "Pagamento", agendamento.getPagamento().getId());

        esseRegistroEstaAtivo(profissionalRepository.existsByIdAndStatus(agendamento.getProfissional().getId(),
                STATUS_ATIVO), "Profissional", agendamento.getProfissional().getId());

        validarProdutosAtivos(agendamento.getProdutos()
                .stream()
                .map(Produto::getId)
                .toList());

        AgendamentoDBEntity agendamentoDB = toDbEntity(agendamento);

        if (repository.existeConflito(agendamentoDB.getProfissional().getId(), agendamentoDB.getDataAgendamento())) {
            throw new IllegalArgumentException("Conflito de agendamento para o profissional no horário informado.");
        }

        return toDomain(repository.save(agendamentoDB));
    }

    @Override
    public Agendamento buscarAgendamentoAtivo(Long id) {

        if (!repository.existsByIdAndStatus(id, STATUS_ATIVO)) {
            throw new EntityNotFoundException("Agendamento " + id + " não encontrado ou inativo na base de dados");
        }

        return toDomain(repository.findById(id).orElseThrow());
    }

    @Override
    public List<Agendamento> listarAgendamentosAtivos() {

        if (repository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Nenhum agendamento encontrado na base de dados");
        }

        return repository.findAll().stream().map(AgendamentoMapper::toDomain).toList();
    }

    @Override
    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        return null;
    }

    @Override
    public void excluirAgendamento(Agendamento agendamento) {
        repository.save(toDbEntity(agendamento));
    }

    private void esseRegistroEstaAtivo(boolean existe, String nomeEntidade, Long id) {
        if (!existe) {
            throw new EntityNotFoundException(nomeEntidade + " " + id + " não encontrado ou inativo.");
        }
    }

    private void validarProdutosAtivos(List<Long> produtosIds) {
        if (produtosIds == null || produtosIds.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser vazia.");
        }

        for (Long id : produtosIds) {
            boolean existe = produtoRepository.existsByIdAndStatus(id, STATUS_ATIVO);

            if (!existe) {
                throw new EntityNotFoundException("Produto " + id + " não encontrado ou inativo.");
            }
        }
    }

}
