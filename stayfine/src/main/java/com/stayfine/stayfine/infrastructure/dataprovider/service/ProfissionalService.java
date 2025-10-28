package com.stayfine.stayfine.infrastructure.dataprovider.service;

import com.stayfine.stayfine.core.domain.entity.Profissional;
import com.stayfine.stayfine.core.gateway.ProfissionalGateway;
import com.stayfine.stayfine.infrastructure.dataprovider.mapper.ProfissionalMapper;
import com.stayfine.stayfine.infrastructure.dataprovider.repository.ProfissionalDBEntity;
import com.stayfine.stayfine.infrastructure.dataprovider.repository.ProfissionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.stayfine.stayfine.core.domain.enums.EntityStatus.EXCLUIDO;

@Service
public class ProfissionalService implements ProfissionalGateway {

    private final ProfissionalRepository repository;

    public ProfissionalService(ProfissionalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Profissional inserirProfissional(Profissional profissional) {
        ProfissionalDBEntity profissionalDB = ProfissionalMapper.toDbEntity(profissional);
        return ProfissionalMapper.toDomain(profissionalDB);
    }

    @Override
    public Profissional buscarProfissional(Long id) {
        ProfissionalDBEntity profissionalDB = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional" + id + " não encontrado"));
        return ProfissionalMapper.toDomain(profissionalDB);
    }

    @Override
    public List<Profissional> buscarProfissionais() {
        return repository.findAll().stream()
                .map(ProfissionalMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void atualizarProfissional(Profissional profissional) {
        ProfissionalDBEntity profissionalDB = repository.findById(profissional.getId())
                .orElseThrow(() -> new RuntimeException("Profissional" + profissional.getId() + " não encontrado"));

        if (!profissionalDB.getNome().equals(profissionalDB.getNome())) {
            profissionalDB.setNome(profissional.getNome());
        }
        repository.save(profissionalDB);
    }

    @Override
    public void excluirProfissional(Long id) {
        ProfissionalDBEntity profissionalDB = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profissional" + id + " não encontrado"));

        profissionalDB.setStatus(EXCLUIDO.name());
        repository.save(profissionalDB);
    }
}
