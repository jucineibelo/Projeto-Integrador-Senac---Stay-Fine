package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.enums.DomainStatus;
import com.stayfine.stayfine.core.domain.model.Cliente;
import com.stayfine.stayfine.core.exceptions.DomainException;
import com.stayfine.stayfine.core.gateway.ClienteGateway;
import com.stayfine.stayfine.core.usecase.ClienteUseCase;

import java.time.OffsetDateTime;
import java.util.List;

import static com.stayfine.stayfine.core.util.DomainUtil.deveAtualizar;

public class ClienteUseCaseImpl implements ClienteUseCase {

    final private ClienteGateway gateway;

    public ClienteUseCaseImpl(ClienteGateway clienteGateway) {
        this.gateway = clienteGateway;
    }

    @Override
    public Cliente inserirCliente(Cliente cliente) {
        if (cliente == null) {
            throw new DomainException("Pessoa está vazia");
        }

        cliente.setDataCadastro(OffsetDateTime.now());
        cliente.setStatus(DomainStatus.ATIVO.name());
        return gateway.inserirCliente(cliente);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        if (id == null) {
            throw new DomainException("Id vazio");
        }
        return gateway.buscarCliente(id);
    }

    @Override
    public List<Cliente> listarCliente() {
        return gateway.listarClientes();
    }

    @Override
    public Cliente atualizarCliente(Long id, Cliente cliente) {

        if (id == null || cliente == null) {
            throw new DomainException("Pessoa ou id está vazio");
        }

        Cliente clienteExistente = buscarCliente(id);

        if (deveAtualizar(cliente.getNome(), clienteExistente.getNome())) {
            clienteExistente.setNome(cliente.getNome());
        }

        if (deveAtualizar(cliente.getEmail(), clienteExistente.getEmail())) {
            clienteExistente.setEmail(cliente.getEmail());
        }

        if (deveAtualizar(cliente.getTelefone(), clienteExistente.getTelefone())) {
            clienteExistente.setTelefone(cliente.getTelefone());
        }

        if (deveAtualizar(cliente.getUsername(), clienteExistente.getUsername())) {
            clienteExistente.setUsername(cliente.getUsername());
        }

        if (deveAtualizar(cliente.getPassword(), clienteExistente.getPassword())) {
            clienteExistente.setPassword(cliente.getPassword());
        }

        clienteExistente.setDataAtualizacao(OffsetDateTime.now());
        return gateway.atualizarCliente(clienteExistente);
    }


    @Override
    public void excluirCliente(Long id) {

        if (id == null) {
            throw new DomainException("Id ivalido");
        }

        Cliente clienteExistente = buscarCliente(id);
        clienteExistente.setStatus(DomainStatus.EXCLUIDO.name());
        clienteExistente.setDataAtualizacao(OffsetDateTime.now());
        gateway.excluirCliente(clienteExistente);
    }


}
