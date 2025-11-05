package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.model.Pessoa;
import com.stayfine.stayfine.core.gateway.PessoaGateway;
import com.stayfine.stayfine.core.usecase.PessoaUseCase;

import java.util.List;

public class PessoaUseCaseImpl implements PessoaUseCase {

    final private PessoaGateway gateway;

    public PessoaUseCaseImpl(PessoaGateway pessoaGateway) {
        this.gateway = pessoaGateway;
    }

    @Override
    public Pessoa inserirPessoa(Pessoa pessoa) {
        return null;
    }

    @Override
    public Pessoa buscarPessoa(Long id) {
        return null;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return List.of();
    }

    @Override
    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        return null;
    }

    @Override
    public void excluirPessoa(Long id) {

    }
}
