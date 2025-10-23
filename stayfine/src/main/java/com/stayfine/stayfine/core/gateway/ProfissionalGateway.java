package com.stayfine.stayfine.core.gateway;

import com.stayfine.stayfine.core.domain.Profissional;

import java.util.List;

public interface ProfissionalGateway {

    Profissional inserirProfissional(Profissional profissional);
    Profissional buscarProfissional(Long id);
    List<Profissional> buscarProfissionais();
    void atualizarProfissional(Profissional profissional);
    void excluirProfissional(Long id);
}

// Serve como um contrato para implementar a persistência de dados.
// para persistir os dados em uma fonte de dados (banco de dados, API, etc.).
//Interface de Banco de Dados: Serve como uma abstração da camada de dados,
// isolando a lógica de acesso a dados do restante da aplicação.