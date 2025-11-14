package com.stayfine.stayfine.core.usecase;

import com.stayfine.stayfine.core.domain.model.Cliente;

import java.util.List;

public interface ClienteUseCase {
    Cliente inserirCliente(Cliente cliente);

    Cliente buscarCliente(Long id);

    List<Cliente> listarCliente();

    Cliente atualizarCliente(Long id, Cliente cliente);

    void excluirCliente(Long id);
}
