package com.stayfine.stayfine.configuration;

import com.stayfine.stayfine.core.gateway.*;
import com.stayfine.stayfine.core.usecase.*;
import com.stayfine.stayfine.core.usecase.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ProfissionalUseCase profissionalUseCaseImpl(ProfissionalGateway profissionalGateway) {
        return new ProfissionalUseCaseImpl(profissionalGateway);
    }

    @Bean
    public ProdutoUseCase produtoUseCaseImpl(ProdutoGateway produtoGateway) {
        return new ProdutoUseCaseImpl(produtoGateway);
    }

    @Bean
    public ClienteUseCase clienteUseCaseImpl(ClienteGateway clienteGateway) {
        return new ClienteUseCaseImpl(clienteGateway);
    }

    @Bean
    public PagamentoUseCase pagamentoUseCaseImpl(PagamentoGateway pagamentoGateway) {
        return new PagamentoUseCaseImpl(pagamentoGateway);
    }

    @Bean
    public AgendamentoUseCase agendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        return new AgendamentoUseCaseImpl(agendamentoGateway);
    }
}
