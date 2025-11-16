package com.stayfine.stayfine.entrypoint.dto;

public record ClienteRequest(
        String nome,
        String email,
        String telefone,
        String username,
        String password
) {

}
