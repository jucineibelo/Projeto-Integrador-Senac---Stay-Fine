package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.core.gateway.PagamentoGateway;

import java.util.List;

public class PagamentoPersistenceAdapter implements PagamentoGateway{

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
    public Pagamento atualizarPagamento(Pagamento pagamento) {
        return null;
    }

    @Override
    public void excluirPagamento(Pagamento pagamento) {

    }
}
