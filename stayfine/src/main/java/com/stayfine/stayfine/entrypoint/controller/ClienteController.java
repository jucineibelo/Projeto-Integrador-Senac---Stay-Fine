package com.stayfine.stayfine.entrypoint.controller;

import com.stayfine.stayfine.core.domain.model.Cliente;
import com.stayfine.stayfine.core.usecase.ClienteUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    public ClienteController(ClienteUseCase clienteUseCase) {
        this.clienteUseCase = clienteUseCase;
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteUseCase.inserirCliente(cliente));
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> buscarClienteId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteUseCase.buscarCliente(id));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteUseCase.listarCliente());
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteUseCase.atualizarCliente(id, cliente));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        clienteUseCase.excluirCliente(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
