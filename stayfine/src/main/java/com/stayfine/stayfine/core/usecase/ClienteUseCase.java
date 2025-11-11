package com.stayfine.stayfine.core.usecase;

import com.stayfine.stayfine.core.domain.model.Cliente;

import java.util.List;

public interface ClienteUseCase {
    Cliente inserirPessoa(Cliente cliente);

    Cliente buscarPessoa(Long id);

    List<Cliente> listarPessoas();

    Cliente atualizarPessoa(Long id, Cliente cliente);

    void excluirPessoa(Long id);
}
