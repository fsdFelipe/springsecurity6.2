package com.app.auth.dto;

import com.app.auth.model.enums.Perfil;

public record UsuarioDto(String email, String senha, Perfil perfil) {

}
