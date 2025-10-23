package com.stayfine.stayfine.infrastructure.dataprovider.repository;

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

    @Column(name = "data_registro")
    private OffsetDateTime dataRegistro;

    @Column(name = "data_atualizacao")
    private OffsetDateTime dataAtualizacao;
}
