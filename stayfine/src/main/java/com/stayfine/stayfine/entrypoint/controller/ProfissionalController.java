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

import static com.stayfine.stayfine.entrypoint.mapper.ProfissionalDtoMapper.*;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalUseCase profissionalUseCase;

    public ProfissionalController(ProfissionalUseCase profissionalUseCase) {
        this.profissionalUseCase = profissionalUseCase;
    }

    @PostMapping
    public ResponseEntity<ProfissionalResponse> inserir(@RequestBody ProfissionalRequest request) {
        Profissional profissional = requestToDomain(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(domainToResponse(profissionalUseCase.inserirProfissional(profissional)));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfissionalResponse> buscarId(@PathVariable Long id) {
        Profissional profissional = profissionalUseCase.buscarProfissional(id);
        return ResponseEntity.ok(domainToResponse(profissional));
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponse>> listarTodos() {
        List<ProfissionalResponse> listaProfissionais = profissionalUseCase.buscarProfissionais()
                .stream()
                .map(ProfissionalDtoMapper::domainToResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaProfissionais);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProfissionalResponse> atualizarProfissional(@PathVariable Long id, @RequestBody ProfissionalRequest profissionalRequest) {
        Profissional model = profissionalUseCase.atualizarProfissional(id, requestToDomain(profissionalRequest));
        return ResponseEntity.status(HttpStatus.OK).body(domainToResponse(model));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirProfissional(@PathVariable Long id) {
        profissionalUseCase.excluirProfissional(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
