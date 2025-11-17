package com.stayfine.stayfine.entrypoint.mapper;

import com.stayfine.stayfine.core.domain.model.*;
import com.stayfine.stayfine.entrypoint.dto.AgendamentoRequest;
import com.stayfine.stayfine.entrypoint.dto.AgendamentoResponse;

public class AgendamentoDtoMapper {

    public static AgendamentoResponse toResponse(Agendamento agendamento) {
        return new AgendamentoResponse(
                agendamento.getId(),
                agendamento.getDataCadastro(),
                agendamento.getCliente().getNome(),
                agendamento.getPagamento().getDescricao(),
                agendamento.getProfissional().getNome(),
                agendamento.getProdutos()
                        .stream()
                        .map(Produto::getDescricao)
                        .toList(),
                agendamento.getDataAgendamento()
        );
    }

    public static Agendamento toDomain(AgendamentoRequest request) {
        return new Agendamento(
                new Cliente(request.clienteId()),
                new Pagamento(request.pagamentoId()),
                new Profissional(request.profissionalId()),
                request.produtosIds().stream().map(Produto::new).toList(),
                request.dataAgendamento()
        );
    }
}
