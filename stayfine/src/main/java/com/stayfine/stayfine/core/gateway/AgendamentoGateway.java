package com.stayfine.stayfine.core.gateway;

import com.stayfine.stayfine.core.domain.model.Agendamento;

import java.util.List;

public interface AgendamentoGateway {
    Agendamento inserirAgendamento(Agendamento agendamento);

    Agendamento buscarAgendamento(Agendamento agendamento);

    List<Agendamento> listarAgendamentos();

    Agendamento atualizarAgendamento(Long id, Agendamento agendamento);

    void excluirAgendamento(Agendamento agendamento);
}
