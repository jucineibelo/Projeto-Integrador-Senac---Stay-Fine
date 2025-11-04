package com.stayfine.stayfine.entrypoint.dto;

public class ProfissionalRequest {

    private String nome;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProfissionalRequest() {
    }

    public ProfissionalRequest(Long id, String nome) {
        this.nome = nome;
    }
}
