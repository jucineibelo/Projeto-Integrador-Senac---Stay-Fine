package com.stayfine.stayfine.core.usecase.impl;

import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.core.gateway.AgendamentoGateway;
import com.stayfine.stayfine.core.usecase.AgendamentoUseCase;

import java.util.List;

public class AgendamentoUseCaseImpl implements AgendamentoUseCase {
    private final AgendamentoGateway gateway;

    public AgendamentoUseCaseImpl(AgendamentoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Agendamento inserirAgendamento(Agendamento agendamento) {
        return null;
    }

    @Override
    public Agendamento buscarAgendamento(Agendamento agendamento) {
        return null;
    }

    @Override
    public List<Agendamento> listarAgendamentos() {
        return List.of();
    }

    @Override
    public Agendamento atualizarAgendamento(Long id, Agendamento agendamento) {
        return null;
    }

    @Override
    public void excluirAgendamento(Long id) {

    }
}
