package com.stayfine.stayfine.infrastructure.adapter;

import com.stayfine.stayfine.core.domain.model.Cliente;
import com.stayfine.stayfine.core.gateway.ClienteGateway;
import com.stayfine.stayfine.infrastructure.database.entity.ClienteDBEntity;
import com.stayfine.stayfine.infrastructure.database.repository.ClienteRepository;
import com.stayfine.stayfine.infrastructure.mapper.ClienteMapper;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.stayfine.stayfine.infrastructure.mapper.ClienteMapper.toDbEntity;
import static com.stayfine.stayfine.infrastructure.mapper.ClienteMapper.toDomain;

@Service
public class ClientePersistenseAdapter implements ClienteGateway {

    private static final Logger log = LoggerFactory.getLogger(ClientePersistenseAdapter.class);
    private final ClienteRepository repository;

    public ClientePersistenseAdapter(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Cliente inserirCliente(Cliente cliente) {
        ClienteDBEntity clienteSalvo = repository.save(toDbEntity(cliente));
        log.debug("Cliente salvo id={}", clienteSalvo.getId());
        return toDomain(clienteSalvo);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        ClienteDBEntity clienteDBEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cliente " + id + " não encontrado na base de dados"));

        return toDomain(clienteDBEntity);
    }

    @Override
    public List<Cliente> listarClientes() {
        return repository.findAll()
                .stream()
                .map(ClienteMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public Cliente atualizarCliente(Cliente cliente) {
        ClienteDBEntity clienteDB = repository.save(toDbEntity(cliente));
        log.debug("Cliente atualizado id={}", clienteDB.getId());
        return toDomain(clienteDB);
    }

    @Override
    @Transactional
    public void excluirCliente(Cliente cliente) {
        ClienteDBEntity clienteDB = repository.save(toDbEntity(cliente));
        log.debug("Cliente marcado como EXCLUIDO id={}", clienteDB.getId());
    }
}