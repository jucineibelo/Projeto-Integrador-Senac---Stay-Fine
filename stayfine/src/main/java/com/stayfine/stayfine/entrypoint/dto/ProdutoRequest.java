package com.stayfine.stayfine.entrypoint.dto;

public class ProdutoRequest {

    private String descricao;
    private Double preco;

    public ProdutoRequest() {
    }

    public ProdutoRequest(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
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
}
