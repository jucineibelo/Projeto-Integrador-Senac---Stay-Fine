package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.model.Agendamento;
import com.stayfine.stayfine.core.usecase.AgendamentoUseCase;
import com.stayfine.stayfine.entrypoint.dto.AgendamentoRequest;
import com.stayfine.stayfine.entrypoint.dto.AgendamentoRequestUpdate;
import com.stayfine.stayfine.entrypoint.dto.AgendamentoResponse;
import com.stayfine.stayfine.entrypoint.mapper.AgendamentoDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stayfine.stayfine.entrypoint.mapper.AgendamentoDtoMapper.*;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoUseCase agendamentoUseCase;

    public AgendamentoController(AgendamentoUseCase agendamentoUseCase) {
        this.agendamentoUseCase = agendamentoUseCase;
    }

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criarAgendamento(@RequestBody AgendamentoRequest request) {
        Agendamento agendamento = agendamentoUseCase.inserirAgendamento(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(agendamento));
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> listarAgendamentos() {
        List<AgendamentoResponse> agendamentos = agendamentoUseCase.listarAgendamentos()
                .stream()
                .map(AgendamentoDtoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarAgendamento(@PathVariable Long id) {
        Agendamento agendamento = agendamentoUseCase.buscarAgendamento(id);
        return ResponseEntity.ok(toResponse(agendamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoRequestUpdate request) {
        Agendamento agendamento = agendamentoUseCase.atualizarAgendamento(id, requestUpdateToDomain(request));
        return ResponseEntity.ok(toResponse(agendamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAgendamento(@PathVariable Long id) {
        agendamentoUseCase.excluirAgendamento(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<AgendamentoResponse> atualizarStatusAgendamento(@PathVariable Long id) {
        Agendamento agendamento = agendamentoUseCase.atualizarStatusParaConcluido(id);
        return ResponseEntity.ok(toResponse(agendamento));
    }
}
