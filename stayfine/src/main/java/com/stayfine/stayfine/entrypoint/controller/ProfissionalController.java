package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.entity.Profissional;
import com.stayfine.stayfine.infrastructure.dataprovider.service.ProfissionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    private final ProfissionalService service;

    public ProfissionalController(ProfissionalService service) {
        this.service = service;
    }

    public ResponseEntity<Profissional> inserirProfissional(@RequestBody Profissional profissional) {
        Profissional profissionalSaved = service.inserirProfissional(profissional);
        return ResponseEntity.status(HttpStatus.OK).body(profissionalSaved);
    }

}
