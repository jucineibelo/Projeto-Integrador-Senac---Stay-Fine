package com.stayfine.stayfine.core.gateway;

import com.stayfine.stayfine.core.domain.model.Pessoa;

import java.util.List;

public interface PessoaGateway {

    Pessoa inserirPessoa(Pessoa pessoa);

    Pessoa buscarPessoa(Long id);

    List<Pessoa> listarPessoas();

    Pessoa atualizarPessoa(Long id, Pessoa pessoa);

    void excluirPessoa(Long id);
}
