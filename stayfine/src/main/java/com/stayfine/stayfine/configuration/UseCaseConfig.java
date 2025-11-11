package com.stayfine.stayfine.configuration;

import com.stayfine.stayfine.core.gateway.ProdutoGateway;
import com.stayfine.stayfine.core.gateway.ProfissionalGateway;
import com.stayfine.stayfine.core.usecase.ProdutoUseCase;
import com.stayfine.stayfine.core.usecase.ProfissionalUseCase;
import com.stayfine.stayfine.core.usecase.impl.ProdutoUseCaseImpl;
import com.stayfine.stayfine.core.usecase.impl.ProfissionalUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public ProfissionalUseCase profissionalUseCaseImpl(ProfissionalGateway profissionalGateway) {
        return new ProfissionalUseCaseImpl(profissionalGateway);
    }

    @Bean
    public ProdutoUseCase produtoUseCaseImpl(ProdutoGateway produtoGateway){
        return new ProdutoUseCaseImpl(produtoGateway);
    }

}
