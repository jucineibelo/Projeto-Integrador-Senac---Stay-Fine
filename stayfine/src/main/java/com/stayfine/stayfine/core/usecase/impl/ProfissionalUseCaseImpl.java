package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.Profissional;
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
        return gateway.buscarProfissionais();
    }

    @Override
    public void atualizarProfissional(Profissional profissional) {

        if (profissional == null) {
            throw new RuntimeException("Profissonal não encontrado");
        }

        Profissional profissionalData = buscarProfissional(profissional.getId());

        if (!profissionalData.getNome().equals(profissional.getNome())) {
            profissionalData.setNome(profissional.getNome());
        }

        gateway.atualizarProfissional(profissionalData);
    }

    @Override
    public void excluirProfissional(Long id) {
        if (id == null) {
            throw new RuntimeException("Profissional não encontrado");
        }

        gateway.excluirProfissional(id);
    }
}
