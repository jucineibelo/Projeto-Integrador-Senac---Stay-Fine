package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.entity.Profissional;
import com.stayfine.stayfine.core.domain.enums.EntityStatus;
import com.stayfine.stayfine.core.gateway.ProfissionalGateway;
import com.stayfine.stayfine.core.usecase.ProfissionalUseCase;

import java.time.OffsetDateTime;
import java.util.List;

public class ProfissionalUseCaseImpl implements ProfissionalUseCase {

    final private ProfissionalGateway gateway;

    public ProfissionalUseCaseImpl(ProfissionalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Profissional inserirProfissional(Profissional profissional) {

        if (profissional == null) {
            throw new RuntimeException("Profissonal vazio");
        }

        profissional.setDataRegistro(OffsetDateTime.now());
        profissional.setStatus(EntityStatus.ATIVO.name());
        return gateway.inserirProfissional(profissional);
    }

    @Override
    public Profissional buscarProfissional(Long id) {
        if (id == null) {
            throw new RuntimeException(id + " Registro não encontrado.");
        }
        return gateway.buscarProfissional(id);
    }

    @Override
    public List<Profissional> buscarProfissionais() {

        if (gateway.buscarProfissionais().isEmpty()) {
            throw new RuntimeException("A lista está vazia!");
        }
        return gateway.buscarProfissionais();
    }

    @Override
    public Profissional atualizarProfissional(Long id, Profissional profissional) {

        if (id == null) {
            throw new RuntimeException("id está vazio");
        }

        Profissional profissionalData = buscarProfissional(id);

        if (!profissionalData.getNome().equals(profissional.getNome())) {
            profissionalData.setNome(profissional.getNome());
            profissionalData.setDataAtualizacao(OffsetDateTime.now());
        }

        return gateway.atualizarProfissional(id, profissionalData);
    }

    @Override
    public void excluirProfissional(Long id) {
        if (id == null) {
            throw new RuntimeException("Profissional não encontrado");
        }

        gateway.excluirProfissional(id);
    }
}
