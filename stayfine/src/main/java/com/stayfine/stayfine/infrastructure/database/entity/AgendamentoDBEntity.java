package com.stayfine.stayfine.infrastructure.database.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
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
    private OffsetDateTime dataAtualizacao;

    @Column(name = "status")
    private String status;

    // Um cliente pode ter vários agendamentos
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteDBEntity cliente;

    // Um profissional pode ter vários agendamentos, mas um agendamento só tem 1 profissional
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private ProfissionalDBEntity profissional;

    // Relacionamento 1:1 - um agendamento tem 1 pagamento
    @OneToOne
    @JoinColumn(name = "pagamento_id", unique = false)
    private PagamentoDBEntity pagamento;

    // Agendamento pode ter vários produtos, e produtos podem aparecer em vários agendamentos
    @ManyToMany
    @JoinTable(
            name = "agendamento_produto",
            joinColumns = @JoinColumn(name = "agendamento_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProdutoDBEntity> produtos;

    @Column(name = "data_agendamento")
    private LocalDateTime dataAgendamento;

    public AgendamentoDBEntity() {

    }

    public AgendamentoDBEntity(Long id, OffsetDateTime dataCadastro, OffsetDateTime dataAtualizacao, String status,
                               ClienteDBEntity cliente, ProfissionalDBEntity profissional, PagamentoDBEntity pagamento,
                               List<ProdutoDBEntity> produtos, LocalDateTime dataAgendamento) {
        this.id = id;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.status = status;
        this.cliente = cliente;
        this.profissional = profissional;
        this.pagamento = pagamento;
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

    public ClienteDBEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDBEntity cliente) {
        this.cliente = cliente;
    }

    public ProfissionalDBEntity getProfissional() {
        return profissional;
    }

    public void setProfissional(ProfissionalDBEntity profissional) {
        this.profissional = profissional;
    }

    public PagamentoDBEntity getPagamento() {
        return pagamento;
    }

    public void setPagamento(PagamentoDBEntity pagamento) {
        this.pagamento = pagamento;
    }

    public List<ProdutoDBEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDBEntity> produtos) {
        this.produtos = produtos;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
