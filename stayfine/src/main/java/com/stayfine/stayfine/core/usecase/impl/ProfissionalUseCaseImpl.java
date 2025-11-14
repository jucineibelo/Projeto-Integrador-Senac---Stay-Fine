package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.enums.DomainStatus;
import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.core.exceptions.DomainException;
import com.stayfine.stayfine.core.gateway.ProfissionalGateway;
import com.stayfine.stayfine.core.usecase.ProfissionalUseCase;

import java.time.OffsetDateTime;
import java.util.List;

import static com.stayfine.stayfine.core.util.DomainUtil.deveAtualizar;

public class ProfissionalUseCaseImpl implements ProfissionalUseCase {

    final private ProfissionalGateway gateway;

    public ProfissionalUseCaseImpl(ProfissionalGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Profissional inserirProfissional(Profissional profissional) {

        if (profissional == null) {
            throw new DomainException("Profissonal vazio");
        }

        profissional.setDataCadastro(OffsetDateTime.now());
        profissional.setStatus(DomainStatus.ATIVO.name());
        return gateway.inserirProfissional(profissional);
    }

    @Override
    public Profissional buscarProfissional(Long id) {
        if (id == null) {
            throw new DomainException(id + " Registro não informado.");
        }
        return gateway.buscarProfissional(id);
    }

    @Override
    public List<Profissional> buscarProfissionais() {

        if (gateway.buscarProfissionais().isEmpty()) {
            throw new DomainException("A lista está vazia!");
        }
        return gateway.buscarProfissionais();
    }

    @Override
    public Profissional atualizarProfissional(Long id, Profissional profissional) {

        if (id == null || profissional == null) {
            throw new DomainException("Profissional ou id está vazio");
        }

        Profissional profissionalExistente = buscarProfissional(id);

        if (deveAtualizar(profissional.getNome(), profissionalExistente.getNome())) {
            profissionalExistente.setNome(profissional.getNome());
            profissionalExistente.setDataAtualizacao(OffsetDateTime.now());
        }

        return gateway.atualizarProfissional(profissionalExistente);
    }


    @Override
    public void excluirProfissional(Long id) {

        if (id == null) {
            throw new DomainException("O código está vazio");
        }

        Profissional buscarProfissional = buscarProfissional(id);
        buscarProfissional.setStatus(DomainStatus.EXCLUIDO.name());
        buscarProfissional.setDataAtualizacao(OffsetDateTime.now());
        gateway.excluirProfissional(buscarProfissional);
    }
}
