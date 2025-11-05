package com.stayfine.stayfine.core.usecase;

import com.stayfine.stayfine.core.domain.model.Pessoa;

import java.util.List;

public interface PessoaUseCase {
    Pessoa inserirPessoa(Pessoa pessoa);

    Pessoa buscarPessoa(Long id);

    List<Pessoa> listarPessoas();

    Pessoa atualizarPessoa(Long id, Pessoa pessoa);

    void excluirPessoa(Long id);
}
