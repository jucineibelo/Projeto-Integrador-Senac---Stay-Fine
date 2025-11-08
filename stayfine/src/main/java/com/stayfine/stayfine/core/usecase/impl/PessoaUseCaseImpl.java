package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.enums.DomainStatus;
import com.stayfine.stayfine.core.domain.model.Pessoa;
import com.stayfine.stayfine.core.exceptions.DomainException;
import com.stayfine.stayfine.core.gateway.PessoaGateway;
import com.stayfine.stayfine.core.usecase.PessoaUseCase;
import java.time.OffsetDateTime;
import java.util.List;

import static com.stayfine.stayfine.core.util.DomainUtil.deveAtualizar;

public class PessoaUseCaseImpl implements PessoaUseCase {

    final private PessoaGateway gateway;

    public PessoaUseCaseImpl(PessoaGateway pessoaGateway) {
        this.gateway = pessoaGateway;
    }

    @Override
    public Pessoa inserirPessoa(Pessoa pessoa) {
        if (pessoa == null) {
            throw new DomainException("Pessoa está vazia");
        }

        pessoa.setDataCadastro(OffsetDateTime.now());
        pessoa.setStatus(DomainStatus.ATIVO.name());
        return gateway.inserirPessoa(pessoa);
    }

    @Override
    public Pessoa buscarPessoa(Long id) {
        if (id == null) {
            throw new DomainException("Id vazio");
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
            throw new DomainException("Pessoa ou id está vazio");
        }

        Pessoa pessoaExistente = buscarPessoa(id);

        if (deveAtualizar(pessoa.getNome(), pessoaExistente.getNome())) {
            pessoaExistente.setNome(pessoa.getNome());
        }

        if (deveAtualizar(pessoa.getEmail(), pessoaExistente.getEmail())) {
            pessoaExistente.setEmail(pessoa.getEmail());
        }

        if (deveAtualizar(pessoa.getTelefone(), pessoaExistente.getTelefone())) {
            pessoaExistente.setTelefone(pessoa.getTelefone());
        }

        if (deveAtualizar(pessoa.getUsername(), pessoaExistente.getUsername())) {
            pessoaExistente.setUsername(pessoa.getUsername());
        }

        if (deveAtualizar(pessoa.getPassword(), pessoaExistente.getPassword())){
            pessoaExistente.setPassword(pessoa.getPassword());
        }

        pessoaExistente.setDataAtualizacao(OffsetDateTime.now());
        return gateway.atualizarPessoa(id, pessoaExistente);
    }


    @Override
    public void excluirPessoa(Long id) {

        if (id == null) {
            throw new DomainException("Id ivalido");
        }

        Pessoa pessoaExistente = buscarPessoa(id);
        pessoaExistente.setStatus(DomainStatus.EXCLUIDO.name());
        gateway.excluirPessoa(pessoaExistente.getId());
    }


}
