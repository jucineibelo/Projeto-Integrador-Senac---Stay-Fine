package com.stayfine.stayfine.core.usecase;

import com.stayfine.stayfine.core.domain.entity.Profissional;
import java.util.List;

public interface ProfissionalUseCase {
    Profissional inserirProfissional(Profissional profissional);
    Profissional buscarProfissional(Long id);
    List<Profissional> buscarProfissionais();
    void atualizarProfissional(Profissional profissional);
    void excluirProfissional(Long id);
}

//Define os casos de uso e a lógica de negócios relacionada às operações realizadas com objetos do tipo Profissional.
//Responsabilidades:
//Orquestração da Lógica de Negócio: Métodos que representam ações específicas que os usuários ou sistemas podem realizar
// sobre os dados do profissional, implementando regras de negócio.
//Validações e Regras: Pode incluir lógica para validar dados de entrada antes de interagir com a camada de dados.