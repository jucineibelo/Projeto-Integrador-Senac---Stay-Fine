package com.stayfine.stayfine.core.domain.model;

import java.time.OffsetDateTime;

public class Pagamento {
    private Long id;
    private String descricao;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataAtualizacao;
    private String status;
    private String tipo;

    public Pagamento() {
    }

    public Pagamento(String descricao, String tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
    }

    public Pagamento(Long id, String descricao, OffsetDateTime dataCadastro, OffsetDateTime dataAtualizacao, String status, String tipo) {
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
