package com.app.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.auth.dto.UsuarioDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class UsuarioController {
	
	//Esses endpoints serão sempre permitidos sem restrições
	@GetMapping
	public String bemVindo() {
		return "Bem Vindo !";
	}

	@PostMapping
	public UsuarioDto usuario(@RequestBody @Valid UsuarioDto usuarioDto) {
		return usuarioDto;
		}

}
