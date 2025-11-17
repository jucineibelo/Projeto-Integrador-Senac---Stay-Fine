package com.stayfine.stayfine.core.domain.model;

import java.time.OffsetDateTime;
import java.util.List;

public class Agendamento {
    private Long id;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataAtualizacao;
    private String status;
    private Cliente cliente;
    private Pagamento pagamento;
    private Profissional profissional;
    private List<Produto> produtos;
    private OffsetDateTime dataAgendamento;


    public Agendamento(Long id, OffsetDateTime dataCadastro, OffsetDateTime dataAtualizacao, String status,
                       Cliente cliente, Pagamento pagamento, Profissional profissional, List<Produto> produtos,
                       OffsetDateTime dataAgendamento) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.status = status;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.profissional = profissional;
        this.produtos = produtos;
        this.dataAgendamento = dataAgendamento;
    }

    public Agendamento(Cliente cliente, Pagamento pagamento, Profissional profissional, List<Produto> produtos,
                       OffsetDateTime offsetDateTime) {

        this.cliente = cliente;
        this.pagamento = pagamento;
        this.profissional = profissional;
        this.produtos = produtos;
        this.dataAgendamento = offsetDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public OffsetDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(OffsetDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
