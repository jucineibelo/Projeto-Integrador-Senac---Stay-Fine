package com.stayfine.stayfine.entrypoint.dto;

import java.time.OffsetDateTime;

public class ProdutoResponse {

    private Long id;
    private String descricao;
    private Double preco;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataAtualizacao;
    private String status;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Long id, String descricao, Double preco, OffsetDateTime dataCadastro,
                           OffsetDateTime dataAtualizacao, String status) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.status = status;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
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
}
