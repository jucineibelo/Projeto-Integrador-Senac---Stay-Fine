package com.stayfine.stayfine.infrastructure.database.entity;


import com.stayfine.stayfine.core.domain.model.Cliente;
import com.stayfine.stayfine.core.domain.model.Pagamento;
import com.stayfine.stayfine.core.domain.model.Produto;
import com.stayfine.stayfine.core.domain.model.Profissional;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "agendamento")
public class AgendamentoDBEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_cadastro")
    private OffsetDateTime dataCadastro;

    @Column(name = "data_atualizacao")
    private OffsetDateTime dataAtualização;

    @Column(name = "status")
    private String status;

    @Column(name = "pessoa")
    private Cliente cliente;

    @Column(name = "pagamento")
    private Pagamento pagamento;

    @Column(name = "profissional")
    private Profissional profissional;

    @Column(name = "produtos")
    private List<Produto> produtos;

    @Column(name = "data_agendamento")
    private OffsetDateTime dataAgendamento;

    public AgendamentoDBEntity() {

    }

    public AgendamentoDBEntity(Long id, OffsetDateTime dataCadastro, OffsetDateTime dataAtualização, String status,
                               Cliente cliente, Pagamento pagamento, Profissional profissional, List<Produto> produtos,
                               OffsetDateTime dataAgendamento) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.dataAtualização = dataAtualização;
        this.status = status;
        this.cliente = cliente;
        this.pagamento = pagamento;
        this.profissional = profissional;
        this.produtos = produtos;
        this.dataAgendamento = dataAgendamento;
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

    public OffsetDateTime getDataAtualização() {
        return dataAtualização;
    }

    public void setDataAtualização(OffsetDateTime dataAtualização) {
        this.dataAtualização = dataAtualização;
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
