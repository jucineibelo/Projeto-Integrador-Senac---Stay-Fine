package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.core.exceptions.DomainException;
import com.stayfine.stayfine.core.gateway.PagamentoGateway;
import com.stayfine.stayfine.core.usecase.PagamentoUseCase;

import java.time.OffsetDateTime;
import java.util.List;

import static com.stayfine.stayfine.core.domain.enums.DomainStatus.INATIVO;
import static com.stayfine.stayfine.core.util.DomainUtil.deveAtualizar;

public class PagamentoUseCaseImpl implements PagamentoUseCase {

    final private PagamentoGateway gateway;

    public PagamentoUseCaseImpl(PagamentoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Pagamento inserirPagamento(Pagamento pagamento) {

        if (pagamento == null) {
            throw new DomainException("Pagamento está vazio");
        }

        pagamento.setDataCadastro(OffsetDateTime.now());
        pagamento.setStatus("ATIVO");
        return gateway.inserirPagamento(pagamento);
    }

    @Override
    public Pagamento buscarPagamento(Long id) {

        if (id == null) {
            throw new DomainException("O código do pagamento está vazio");
        }

        return gateway.buscarPagamento(id);
    }

    @Override
    public List<Pagamento> listarPagamentos() {
        return gateway.listarPagamentos();
    }

    @Override
    public Pagamento atualizarPagamento(Long id, Pagamento pagamento) {

        if (id == null || pagamento == null) {
            throw new DomainException("Dados incompletos para atualizar registro");
        }

        Pagamento pagamentoExistente = buscarPagamento(id);

        boolean atualizou = false;

        if(deveAtualizar(pagamento.getDescricao(), pagamentoExistente.getDescricao())) {
            pagamentoExistente.setDescricao(pagamento.getDescricao());
            atualizou = true;
        }

        if (deveAtualizar(pagamento.getTipo(), pagamentoExistente.getTipo())) {
            pagamentoExistente.setTipo(pagamento.getTipo());
            atualizou = true;
        }

        if (atualizou) {
            pagamentoExistente.setDataAtualizacao(OffsetDateTime.now());
        }

        return gateway.atualizarPagamento(pagamentoExistente);
    }

    @Override
    public void excluirPagamento(Long id) {

        if (id == null) {
            throw new DomainException("O código do pagamento está vazio");
        }

        Pagamento pagamentoExistente = buscarPagamento(id);
        pagamentoExistente.setStatus(INATIVO.name());
        pagamentoExistente.setDataAtualizacao(OffsetDateTime.now());
        gateway.excluirPagamento(pagamentoExistente);
    }
}
