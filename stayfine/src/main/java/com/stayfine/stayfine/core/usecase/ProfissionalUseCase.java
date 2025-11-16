package com.stayfine.stayfine.core.usecase;

import com.stayfine.stayfine.core.domain.model.Profissional;

import java.util.List;

public interface ProfissionalUseCase {
    Profissional inserirProfissional(Profissional profissional);

    Profissional buscarProfissional(Long id);

    List<Profissional> buscarProfissionais();

    Profissional atualizarProfissional(Long id, Profissional profissional);

    void excluirProfissional(Long id);

    List<Profissional> listarProfissionaisAtivos();
}

//Define os casos de uso e a lógica de negócios relacionada às operações realizadas com objetos do tipo Profissional.
//Responsabilidades:
//Orquestração da Lógica de Negócio: Métodos que representam ações específicas que os usuários ou sistemas podem realizar
// sobre os dados do profissional, implementando regras de negócio.
//Validações e Regras: Pode incluir lógica para validar dados de entrada antes de interagir com a camada de dados.