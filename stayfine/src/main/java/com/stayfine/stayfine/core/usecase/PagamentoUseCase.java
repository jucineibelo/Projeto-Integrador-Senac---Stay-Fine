package com.stayfine.stayfine.core.usecase;

import com.stayfine.stayfine.core.domain.model.Pagamento;

import java.util.List;

public interface PagamentoUseCase {
    Pagamento inserirPagamento(Pagamento pagamento);

    Pagamento buscarPagamento(Long id);

    List<Pagamento> listarPagamentos();

    Pagamento atualizarPagamento(Long id, Pagamento pagamento);

    void excluirPagamento(Long id);

}
