package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.entity.Profissional;
import com.stayfine.stayfine.core.usecase.ProfissionalUseCase;
import com.stayfine.stayfine.infrastructure.dataprovider.service.ProfissionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalUseCase profissionalUseCase;

    public ProfissionalController(ProfissionalUseCase profissionalUseCase) {
        this.profissionalUseCase = profissionalUseCase;
    }

    @PostMapping
    public ResponseEntity<Profissional> criar(@RequestBody Profissional profissional) {
        Profissional salvo = profissionalUseCase.inserirProfissional(profissional);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Profissional> buscarId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(profissionalUseCase.buscarProfissional(id));
    }

    @GetMapping
    public ResponseEntity<List<Profissional>> listarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(profissionalUseCase.buscarProfissionais());
    }

    @PutMapping("{id}")
    public ResponseEntity<Profissional> atualizarProfissional(@PathVariable Long id, @RequestBody Profissional profissional) {
        return ResponseEntity.status(HttpStatus.OK).body(profissionalUseCase.atualizarProfissional(id, profissional));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirProfissional(@PathVariable Long id) {
        profissionalUseCase.excluirProfissional(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
