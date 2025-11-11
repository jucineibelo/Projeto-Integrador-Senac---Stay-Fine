package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.usecase.ProdutoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("produto")
@RestController
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @PostMapping
    public ResponseEntity<Produto> inserirProduto(@RequestBody Produto produto) {
        Produto salvo = produtoUseCase.inserirProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> buscarId(@PathVariable Long id) {
        Produto salvo = produtoUseCase.buscarProduto(id);
        return ResponseEntity.status(HttpStatus.OK).body(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){
        List<Produto> listaDeProdutos = produtoUseCase.listarProdutos();
        return ResponseEntity.status(HttpStatus.OK).body(listaDeProdutos);
    }

}
