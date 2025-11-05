package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.model.Profissional;
import com.stayfine.stayfine.core.usecase.ProfissionalUseCase;
import com.stayfine.stayfine.entrypoint.dto.ProfissionalRequest;
import com.stayfine.stayfine.entrypoint.dto.ProfissionalResponse;
import com.stayfine.stayfine.entrypoint.mapper.ProfissionalDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalUseCase profissionalUseCase;
    private final ProfissionalDtoMapper mapper;

    public ProfissionalController(ProfissionalUseCase profissionalUseCase, ProfissionalDtoMapper mapper) {
        this.profissionalUseCase = profissionalUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProfissionalResponse> criar(@RequestBody ProfissionalRequest request) {
        Profissional salvo = profissionalUseCase.inserirProfissional(mapper.requestToDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.domainToResponse(salvo));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfissionalResponse> buscarId(@PathVariable Long id) {
        Profissional profissional = profissionalUseCase.buscarProfissional(id);
        return ResponseEntity.ok(mapper.domainToResponse(profissional));
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> listarTodos() {
        List<ProfissionalResponse> listaProfissionais = profissionalUseCase.buscarProfissionais()
                .stream()
                .map(mapper::domainToResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaProfissionais);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProfissionalResponse> atualizarProfissional(@PathVariable Long id, @RequestBody Profissional profissional) {
        Profissional model = profissionalUseCase.atualizarProfissional(id, profissional);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.domainToResponse(model));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirProfissional(@PathVariable Long id) {
        profissionalUseCase.excluirProfissional(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
