package com.stayfine.stayfine.core.domain.model;

import java.time.OffsetDateTime;

public class Cliente {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataAtualizacao;
    private String status;
    private String username;
    private String password;

    public Cliente() {
    }

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(Long id, String nome, String email, String telefone, OffsetDateTime dataCadastro,
                   OffsetDateTime dataAtualizacao, String status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.status = status;
    }

    public Cliente(Long id, String nome, String email, String telefone, OffsetDateTime dataCadastro,
                   OffsetDateTime dataAtualizacao, String status, String username, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.status = status;
        this.username = username;
        this.password = password;
    }

    public Cliente(String nome, String email, String telefone, String username, String password) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public OffsetDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(OffsetDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
