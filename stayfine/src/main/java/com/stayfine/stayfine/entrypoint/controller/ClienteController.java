package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.model.Cliente;
import com.stayfine.stayfine.core.usecase.ClienteUseCase;
import com.stayfine.stayfine.entrypoint.dto.ClienteRequest;
import com.stayfine.stayfine.entrypoint.dto.ClienteResponse;
import com.stayfine.stayfine.entrypoint.mapper.ClienteDtoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.stayfine.stayfine.entrypoint.mapper.ClienteDtoMapper.toDomain;
import static com.stayfine.stayfine.entrypoint.mapper.ClienteDtoMapper.toResponse;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> inserir(@RequestBody ClienteRequest request) {
        Cliente cliente = clienteUseCase.inserirCliente(toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(toResponse(cliente));
    }

    @GetMapping("{id}")
    public ResponseEntity<ClienteResponse> buscarClienteId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(toResponse(clienteUseCase.buscarCliente(id)));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> buscarTodos() {

        List<ClienteResponse> clientes = clienteUseCase.listarCliente()
                .stream()
                .map(ClienteDtoMapper::toResponse)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClienteResponse> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest request) {
        Cliente cliente = clienteUseCase.atualizarCliente(id, toDomain(request));
        return ResponseEntity.status(HttpStatus.OK).body(toResponse(cliente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        clienteUseCase.excluirCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
