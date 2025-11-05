package com.stayfine.stayfine.configuration;

import com.stayfine.stayfine.entrypoint.mapper.ProfissionalDtoMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ProfissionalDtoMapper profissionalDtoMapper() {
        return new ProfissionalDtoMapper();
    }
}
