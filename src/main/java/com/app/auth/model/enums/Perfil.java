package com.app.auth.model.enums;

public enum Perfil {
	ADMIN("ADMIN"), 
	MANAGER("MANAGER"), 
	USUARIO("USUARIO");

	private String descricao;

	Perfil(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
