package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.enums.DomainStatus;
import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.core.exceptions.DomainException;
import com.stayfine.stayfine.core.gateway.AgendamentoGateway;
import com.stayfine.stayfine.core.usecase.AgendamentoUseCase;

import java.time.OffsetDateTime;
import java.util.List;

public class AgendamentoUseCaseImpl implements AgendamentoUseCase {

    private final AgendamentoGateway gateway;

    public AgendamentoUseCaseImpl(AgendamentoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Agendamento inserirAgendamento(Agendamento agendamento) {

        if (agendamento == null) {
            throw new DomainException("Dados incompletos do agendamento");
        }

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
        return null;
    }

    @Override
    public void excluirAgendamento(Long id) {
        Agendamento agendamento = buscarAgendamento(id);
        agendamento.setStatus(DomainStatus.INATIVO.name());
        agendamento.setDataAtualizacao(OffsetDateTime.now());
        gateway.excluirAgendamento(agendamento);
    }
}
