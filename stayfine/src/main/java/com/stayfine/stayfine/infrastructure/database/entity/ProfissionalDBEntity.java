package com.stayfine.stayfine.infrastructure.database.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "profissional")
public class ProfissionalDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "status")
    private String status;

    @Column(name = "data_registro")
    private OffsetDateTime dataRegistro;

    @Column(name = "data_atualizacao")
    private OffsetDateTime dataAtualizacao;

    public ProfissionalDBEntity() {
    }

    public ProfissionalDBEntity(Long id, String nome, String status, OffsetDateTime dataRegistro, OffsetDateTime dataAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.dataRegistro = dataRegistro;
        this.dataAtualizacao = dataAtualizacao;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
