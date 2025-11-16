package com.stayfine.stayfine.core.gateway;

import com.stayfine.stayfine.core.domain.model.Agendamento;

import java.util.List;

public interface AgendamentoGateway {

    Agendamento inserirAgendamento(Agendamento agendamento);

    Agendamento buscarAgendamentoAtivo(Long id);

    List<Agendamento> listarAgendamentosAtivos();

    Agendamento atualizarAgendamento(Agendamento agendamento);

    void excluirAgendamento(Agendamento agendamento);
}
