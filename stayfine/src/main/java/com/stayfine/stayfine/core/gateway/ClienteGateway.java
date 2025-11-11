package com.stayfine.stayfine.core.gateway;

import com.stayfine.stayfine.core.domain.model.Cliente;

import java.util.List;

public interface ClienteGateway {

    Cliente inserirCliente(Cliente cliente);

    Cliente buscarCliente(Long id);

    List<Cliente> listarClientes();

    Cliente atualizarCliente(Long id, Cliente cliente);

    void excluirCliente(Long id);
}
