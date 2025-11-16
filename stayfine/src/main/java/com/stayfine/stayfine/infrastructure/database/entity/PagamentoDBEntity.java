package com.stayfine.stayfine.infrastructure.database.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "pagamento")
public class PagamentoDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_cadastro")
    private OffsetDateTime dataCadastro;

    @Column(name = "data_atualizacao")
    private OffsetDateTime dataAtualizacao;

    @Column(name = "status")
    private String status;

    @Column(name = "tipo")
    private String tipo;

    public PagamentoDBEntity() {
    }

    public PagamentoDBEntity(Long id, String descricao, OffsetDateTime dataCadastro, OffsetDateTime dataAtualizacao,
                             String status, String tipo) {
        this.id = id;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.status = status;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
