package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.core.usecase.PagamentoUseCase;
import com.stayfine.stayfine.entrypoint.dto.PagamentoRequest;
import com.stayfine.stayfine.entrypoint.dto.PagamentoResponse;
import com.stayfine.stayfine.entrypoint.mapper.PagamentoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stayfine.stayfine.entrypoint.mapper.PagamentoDtoMapper.toDomain;
import static com.stayfine.stayfine.entrypoint.mapper.PagamentoDtoMapper.toResponse;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    final PagamentoUseCase pagamentoUseCase;

    public PagamentoController(PagamentoUseCase pagamentoUseCase) {
        this.pagamentoUseCase = pagamentoUseCase;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> inserir(@RequestBody PagamentoRequest request) {
        Pagamento pagamento = pagamentoUseCase.inserirPagamento(toDomain(request));
        return ResponseEntity.ok(toResponse(pagamento));
    }

    @GetMapping("{id}")
    public ResponseEntity<PagamentoResponse> buscarPorId(@PathVariable Long id) {
        Pagamento pagamento = pagamentoUseCase.buscarPagamento(id);
        return ResponseEntity.ok(toResponse(pagamento));
    }

    @GetMapping
    public ResponseEntity<List<PagamentoResponse>> buscarTodos() {
        List<PagamentoResponse> listaDePagamentos =
                pagamentoUseCase.listarPagamentos().stream()
                        .map(PagamentoDtoMapper::toResponse)
                        .toList();

        return ResponseEntity.ok(listaDePagamentos);
    }

    @PutMapping("{id}")
    public ResponseEntity<PagamentoResponse> atualizar(@PathVariable Long id, @RequestBody PagamentoRequest request) {
        Pagamento pagamento = pagamentoUseCase.atualizarPagamento(id, toDomain(request));
        return ResponseEntity.ok(toResponse(pagamento));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pagamentoUseCase.excluirPagamento(id);
        return ResponseEntity.noContent().build();
    }


}
