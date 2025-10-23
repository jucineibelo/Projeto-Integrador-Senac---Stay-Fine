package com.stayfine.stayfine.core.domain;

import java.time.OffsetDateTime;

public class Profissional {

    private Long id;
    private String nome;
    private OffsetDateTime dataRegistro;
    private OffsetDateTime dataAtualizacao;

    public Profissional() {
    }

    public Profissional(Long id, String nome, OffsetDateTime dataRegistro, OffsetDateTime dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.dataRegistro = dataRegistro;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public OffsetDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(OffsetDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public OffsetDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
