package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.enums.DomainStatus;
import com.stayfine.stayfine.core.domain.model.Pessoa;
import com.stayfine.stayfine.core.gateway.PessoaGateway;
import com.stayfine.stayfine.core.usecase.PessoaUseCase;

import java.time.OffsetDateTime;
import java.util.List;

public class PessoaUseCaseImpl implements PessoaUseCase {

    final private PessoaGateway gateway;

    public PessoaUseCaseImpl(PessoaGateway pessoaGateway) {
        this.gateway = pessoaGateway;
    }

    @Override
    public Pessoa inserirPessoa(Pessoa pessoa) {
        if (pessoa == null) {
            throw new RuntimeException("Pessoa está vazia");
        }

        pessoa.setDataCadastro(OffsetDateTime.now());
        pessoa.setStatus(DomainStatus.ATIVO.name());
        return gateway.inserirPessoa(pessoa);
    }

    @Override
    public Pessoa buscarPessoa(Long id) {
        if (id == null) {
            throw new RuntimeException("Id vazio");
        }
        return gateway.buscarPessoa(id);
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return gateway.listarPessoas();
    }

    @Override
    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        if (id == null || pessoa == null) {
            throw new RuntimeException("Pessoa ou id está vazio");
        }

        Pessoa pessoaExistente = buscarPessoa(id);

        if (pessoa.getNome() != null
                && !pessoa.getNome().isBlank()
                && !pessoaExistente.getNome().equals(pessoa.getNome())) {
            pessoaExistente.setNome(pessoa.getNome());
        }

        if (pessoa.getEmail() != null
                && !pessoa.getEmail().isBlank()
                && !pessoaExistente.getEmail().equals(pessoa.getEmail())) {
            pessoaExistente.setEmail(pessoa.getEmail());
        }

        if (pessoa.getTelefone() != null
                && !pessoa.getTelefone().isBlank()
                && !pessoaExistente.getTelefone().equals(pessoa.getTelefone())) {
            pessoaExistente.setTelefone(pessoa.getTelefone());
        }

        if (pessoa.getUsername() != null
                && !pessoa.getUsername().isBlank()
                && !pessoaExistente.getUsername().equals(pessoa.getUsername())) {
            pessoaExistente.setUsername(pessoa.getUsername());
        }

        if (pessoa.getPassword() != null
                && !pessoa.getPassword().isBlank()
                && !pessoaExistente.getPassword().equals(pessoa.getPassword())) {
            pessoaExistente.setPassword(pessoa.getPassword());
        }

        pessoaExistente.setDataAtualizacao(OffsetDateTime.now());
        return gateway.atualizarPessoa(id, pessoaExistente);
    }

    @Override
    public void excluirPessoa(Long id) {

        if (id == null) {
            throw new RuntimeException("Id ivalido");
        }

        Pessoa pessoaExistente = buscarPessoa(id);
        pessoaExistente.setStatus(DomainStatus.EXCLUIDO.name());
        gateway.excluirPessoa(pessoaExistente.getId());
    }
}
