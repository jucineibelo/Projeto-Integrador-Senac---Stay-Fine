package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.enums.DomainStatus;
import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.exceptions.DomainException;
import com.stayfine.stayfine.core.gateway.*;
import com.stayfine.stayfine.core.usecase.AgendamentoUseCase;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;

import static com.stayfine.stayfine.core.util.DomainUtil.deveAtualizar;

public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    private final AgendamentoGateway gateway;
    private final ClienteGateway clienteGateway;
    private final PagamentoGateway pagamentoGateway;
    private final ProfissionalGateway profissionalGateway;
    private final ProdutoGateway produtoGateway;

    public AgendamentoUseCaseImpl(AgendamentoGateway gateway, ClienteGateway clienteGateway, PagamentoGateway pagamentoGateway, ProfissionalGateway profissionalGateway, ProdutoGateway produtoGateway) {
        this.gateway = gateway;
        this.clienteGateway = clienteGateway;
        this.pagamentoGateway = pagamentoGateway;
        this.profissionalGateway = profissionalGateway;
        this.produtoGateway = produtoGateway;
    }

    @Override
    public Agendamento inserirAgendamento(Agendamento agendamento) {

        if (agendamento == null) {
            throw new DomainException("Dados incompletos do agendamento");
        }

        // Carregar cliente completo
        var cliente = clienteGateway.buscarCliente(agendamento.getCliente().getId());
        agendamento.setCliente(cliente);

        // Carregar pagamento completo
        var pagamento = pagamentoGateway.buscarPagamento(agendamento.getPagamento().getId());
        agendamento.setPagamento(pagamento);

        // Carregar profissional completo
        var profissional = profissionalGateway.buscarProfissional(agendamento.getProfissional().getId());
        agendamento.setProfissional(profissional);

        // Carregar produtos
        List<Produto> produtos = agendamento.getProdutos()
                .stream()
                .map(p -> produtoGateway.buscarProduto(p.getId()))
                .toList();

        agendamento.setProdutos(produtos);
        agendamento.setDataCadastro(OffsetDateTime.now());
        agendamento.setStatus(DomainStatus.ATIVO.name());

        return gateway.inserirAgendamento(agendamento);
    }

    @Override
    public Agendamento buscarAgendamento(Long id) {

        if (id == null || id <= 0) {
            throw new DomainException("ID do agendamento inválido");
        }

        return gateway.buscarAgendamentoAtivo(id);
    }

    @Override
    public List<Agendamento> listarAgendamentos() {
        return gateway.listarAgendamentosAtivos();
    }

    @Override
    public Agendamento atualizarAgendamento(Long id, Agendamento agendamento) {

        if (id == null || agendamento == null) {
            throw new DomainException("Agendamento ou id está vazio");
        }

        Agendamento agendamentoExistente = buscarAgendamento(id);

        boolean atualizou = false;

        if (agendamentoExistente.getDataAgendamento() != agendamento.getDataAgendamento()){
            agendamentoExistente.setDataAgendamento(agendamento.getDataAgendamento());
            atualizou = true;
        }

        if (agendamentoExistente.getProfissional() != agendamento.getProfissional()){
            agendamentoExistente.setProfissional(agendamento.getProfissional());
            atualizou = true;
        }

        if (agendamentoExistente.getPagamento() != agendamento.getPagamento()){
            agendamentoExistente.setPagamento(agendamento.getPagamento());
            atualizou = true;
        }

        if (atualizou) {
            agendamentoExistente.setDataAtualizacao(OffsetDateTime.now());
        }

        return gateway.atualizarAgendamento(agendamentoExistente);
    }

    @Override
    public void excluirAgendamento(Long id) {
        Agendamento agendamento = buscarAgendamento(id);
        agendamento.setStatus(DomainStatus.INATIVO.name());
        agendamento.setDataAtualizacao(OffsetDateTime.now());
        gateway.excluirAgendamento(agendamento);
    }
}
