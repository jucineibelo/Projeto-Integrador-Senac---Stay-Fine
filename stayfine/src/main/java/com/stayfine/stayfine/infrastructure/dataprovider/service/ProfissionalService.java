
package com.stayfine.stayfine.infrastructure.dataprovider.service;

import com.stayfine.stayfine.core.domain.entity.Profissional;
import com.stayfine.stayfine.core.gateway.ProfissionalGateway;
import com.stayfine.stayfine.infrastructure.dataprovider.mapper.ProfissionalMapper;
import com.stayfine.stayfine.infrastructure.dataprovider.repository.ProfissionalDBEntity;
import com.stayfine.stayfine.infrastructure.dataprovider.repository.ProfissionalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static com.stayfine.stayfine.core.domain.enums.EntityStatus.EXCLUIDO;

@Service
public class ProfissionalService implements ProfissionalGateway {

    private final ProfissionalRepository repository;
    private final Logger log = LoggerFactory.getLogger(ProfissionalService.class);

    public ProfissionalService(ProfissionalRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Profissional inserirProfissional(Profissional profissional) {
        if (profissional.getDataRegistro() == null) {
            profissional.setDataRegistro(OffsetDateTime.now());
        }

        ProfissionalDBEntity profissionalDB = ProfissionalMapper.toDbEntity(profissional);
        ProfissionalDBEntity saved = repository.save(profissionalDB);
        log.debug("Profissional salvo id={}", saved.getId());

        return ProfissionalMapper.toDomain(saved);
    }

    @Override
    public Profissional buscarProfissional(Long id) {
        ProfissionalDBEntity profissionalDB = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional " + id + " não encontrado"));

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
                .orElseThrow(() -> new RuntimeException("Profissional " + id + " não encontrado"));

        if (profissional.getNome() != null && !profissional.getNome().equals(profissionalDB.getNome())) {
            profissionalDB.setNome(profissional.getNome());
        }

        profissionalDB.setDataAtualizacao(OffsetDateTime.now());
        ProfissionalDBEntity saved = repository.save(profissionalDB);
        log.debug("Profissional atualizado id={}", saved.getId());
        return ProfissionalMapper.toDomain(saved);
    }

    @Override
    @Transactional
    public void excluirProfissional(Long id) {
        ProfissionalDBEntity profissionalDB = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional " + id + " não encontrado"));

        profissionalDB.setStatus(EXCLUIDO.name());
        repository.save(profissionalDB);
        log.debug("Profissional marcado como EXCLUIDO id={}", id);
    }
}
