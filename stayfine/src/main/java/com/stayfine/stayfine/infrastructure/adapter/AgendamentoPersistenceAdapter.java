package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.core.gateway.AgendamentoGateway;
import com.stayfine.stayfine.infrastructure.database.entity.AgendamentoDBEntity;
import com.stayfine.stayfine.infrastructure.database.repository.*;
import com.stayfine.stayfine.infrastructure.mapper.AgendamentoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static com.stayfine.stayfine.infrastructure.mapper.AgendamentoMapper.toDbEntity;
import static com.stayfine.stayfine.infrastructure.mapper.AgendamentoMapper.toDomain;

@Service
public class AgendamentoPersistenceAdapter implements AgendamentoGateway {

    private final String STATUS_AGENDADO = "AGENDADO";
    private final AgendamentoRepository repository;

    public AgendamentoPersistenceAdapter(AgendamentoRepository repository) {
        this.repository = repository;
    }


    @Override
    public Agendamento inserirAgendamento(Agendamento agendamento) {
        AgendamentoDBEntity agendamentoDB = toDbEntity(agendamento);

        if (repository.existeConflito(agendamentoDB.getProfissional().getId(), agendamentoDB.getDataAgendamento())) {
            throw new IllegalArgumentException("Conflito de agendamento para o profissional no horário informado.");
        }

        return toDomain(repository.save(agendamentoDB));
    }

    @Override
    public Agendamento buscarAgendamentoAtivo(Long id) {

        if (!repository.existsByIdAndStatus(id, STATUS_AGENDADO)) {
            throw new EntityNotFoundException("Agendamento " + id + " não encontrado ou inativo na base de dados");
        }

        return toDomain(repository.findById(id).orElseThrow());
    }

    @Override
    public List<Agendamento> listarAgendamentosAtivos() {

        if (repository.findAll().isEmpty()) {
            throw new EntityNotFoundException("Nenhum agendamento encontrado na base de dados");
        }

        return repository.findAll()
                .stream()
                .map(AgendamentoMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        AgendamentoDBEntity agendamentoDB = toDbEntity(agendamento);
        agendamentoDB.setId(agendamento.getId());

        if (!repository.existsByDataAgendamento(agendamento.getDataAgendamento()) &&
                repository.existeConflito(agendamentoDB.getProfissional().getId(), agendamentoDB.getDataAgendamento())) {
            throw new IllegalArgumentException("Conflito de agendamento para o profissional no horário informado.");
        }

        return toDomain(repository.save(agendamentoDB));
    }

    @Override
    public void excluirAgendamento(Agendamento agendamento) {
        repository.save(toDbEntity(agendamento));
    }

    @Override
    @Transactional
    public Agendamento atualizarStatusParaConcluido(Agendamento agendamento) {
        AgendamentoDBEntity agendamentoDB = toDbEntity(agendamento);
        agendamentoDB.setId(agendamento.getId());
        return toDomain(repository.save(agendamentoDB));
    }
}
