package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.core.domain.enums.DomainStatus;
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

        profissional.setDataCadastro(OffsetDateTime.now());
        profissional.setStatus(DomainStatus.ATIVO.name());
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

        if (id == null || profissional == null) {
            throw new RuntimeException("Profissional ou id está vazio");
        }

        Profissional profissionalExistente = buscarProfissional(id);

        if (profissional.getNome() != null
                && !profissional.getNome().isBlank()
                && !profissionalExistente.getNome().equals(profissional.getNome())) {

            profissionalExistente.setNome(profissional.getNome());
            profissionalExistente.setDataAtualizacao(OffsetDateTime.now());
        }

        return gateway.atualizarProfissional(id, profissionalExistente);
    }


    @Override
    public void excluirProfissional(Long id) {
        if (id == null) {
            throw new RuntimeException("Id invalido");
        }

        Profissional profissional = buscarProfissional(id);
        profissional.setStatus(DomainStatus.EXCLUIDO.name());
        gateway.excluirProfissional(profissional.getId());
    }
}
