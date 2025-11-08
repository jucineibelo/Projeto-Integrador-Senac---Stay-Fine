package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.core.gateway.PagamentoGateway;
import com.stayfine.stayfine.core.usecase.PagamentoUseCase;

import java.util.List;

public class PagamentoUseCaseImpl implements PagamentoUseCase {

    final private PagamentoGateway gateway;

    public PagamentoUseCaseImpl(PagamentoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Pagamento inserirPagamento(Pagamento pagamento) {
        return null;
    }

    @Override
    public Pagamento buscarPagamento(Long id) {
        return null;
    }

    @Override
    public List<Pagamento> listarPagamentos() {
        return List.of();
    }

    @Override
    public Pagamento atualizarPagamento(Long id, Pagamento pagamento) {
        return null;
    }

    @Override
    public void excluirPagamento(Long id) {

    }
}
