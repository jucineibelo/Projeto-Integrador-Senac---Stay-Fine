package com.stayfine.stayfine.core.util;

import java.util.Objects;

public class DomainUtil {
    /**
     * Metodo para verificar se dois parametros tipo string são diferentes, caso sejam diferentes podemos atualizar
     * @param novoValor
     * @param valorAtual
     * @return booleano
     */
    public static boolean deveAtualizar(String novoValor, String valorAtual) {
        return novoValor != null
                && !novoValor.isBlank()
                && !Objects.equals(novoValor, valorAtual);
    }
}
