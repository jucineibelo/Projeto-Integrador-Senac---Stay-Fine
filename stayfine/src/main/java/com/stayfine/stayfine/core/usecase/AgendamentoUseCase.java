package com.stayfine.stayfine.core.usecase;

import com.stayfine.stayfine.core.domain.model.Agendamento;

import java.util.List;

public interface AgendamentoUseCase {

    Agendamento inserirAgendamento(Agendamento agendamento);

    Agendamento buscarAgendamento(Long id);

    List<Agendamento> listarAgendamentos();

    Agendamento atualizarAgendamento(Long id, Agendamento agendamento);

    void excluirAgendamento(Long id);
}
