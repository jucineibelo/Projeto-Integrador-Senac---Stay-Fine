package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.usecase.ProdutoUseCase;
import com.stayfine.stayfine.entrypoint.dto.ProdutoRequest;
import com.stayfine.stayfine.entrypoint.dto.ProdutoResponse;
import com.stayfine.stayfine.entrypoint.mapper.ProdutoDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stayfine.stayfine.entrypoint.mapper.ProdutoDtoMapper.domainToResponse;
import static com.stayfine.stayfine.entrypoint.mapper.ProdutoDtoMapper.requestToDomain;

@RequestMapping("produto")
@RestController
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> inserirProduto(@RequestBody ProdutoRequest request) {
        Produto salvo = produtoUseCase.inserirProduto(requestToDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(domainToResponse(salvo));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProdutoResponse> buscarId(@PathVariable Long id) {
        Produto salvo = produtoUseCase.buscarProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body(domainToResponse(salvo));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> buscarTodos() {
        List<ProdutoResponse> listaDeProdutos = produtoUseCase.listarProdutos().stream()
                .map(ProdutoDtoMapper::domainToResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(listaDeProdutos);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Long id, @RequestBody ProdutoRequest request) {
        Produto salvo = produtoUseCase.atualizarProduto(id, requestToDomain(request));
        return ResponseEntity.status(HttpStatus.OK).body(domainToResponse(salvo));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id) {
        produtoUseCase.excluirProduto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
