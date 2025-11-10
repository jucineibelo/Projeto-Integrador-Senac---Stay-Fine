
package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.core.gateway.ProfissionalGateway;
import com.stayfine.stayfine.infrastructure.database.mapper.ProfissionalMapper;
import com.stayfine.stayfine.infrastructure.database.entity.ProfissionalDBEntity;
import com.stayfine.stayfine.infrastructure.database.repository.ProfissionalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.stayfine.stayfine.core.domain.enums.DomainStatus.EXCLUIDO;

@Service
public class ProfissionalPersistenceAdapter implements ProfissionalGateway {

    private final ProfissionalRepository repository;
    private final Logger log = LoggerFactory.getLogger(ProfissionalPersistenceAdapter.class);

    public ProfissionalPersistenceAdapter(ProfissionalRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Profissional inserirProfissional(Profissional profissional) {
        ProfissionalDBEntity profissionalDB = ProfissionalMapper.toDbEntity(profissional);
        ProfissionalDBEntity saved = repository.save(profissionalDB);
        log.debug("Profissional salvo id={}", saved.getId());

        return ProfissionalMapper.toDomain(saved);
    }

    @Override
    public Profissional buscarProfissional(Long id) {
        ProfissionalDBEntity profissionalDB = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional " + id + " não encontrado na base de dados"));

        return ProfissionalMapper.toDomain(profissionalDB);
    }

    @Override
    public List<Profissional> buscarProfissionais() {
        return repository.findAll().stream()
                .map(ProfissionalMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Profissional atualizarProfissional(Long id, Profissional profissional) {
        ProfissionalDBEntity profissionalDB = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional " + id + " não encontrado para atualização."));

        profissionalDB.setId(profissional.getId());
        ProfissionalDBEntity saved = repository.save(profissionalDB);
        log.debug("Profissional atualizado id={}", saved.getId());
        return ProfissionalMapper.toDomain(saved);
    }

    @Override
    @Transactional
    public void excluirProfissional(Long id) {
        ProfissionalDBEntity profissionalDB = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Profissional " + id + " não encontrado para exclusão."));

        repository.save(profissionalDB);
        log.debug("Profissional marcado como EXCLUIDO id={}", id);
    }
}

//somente persistir