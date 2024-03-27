package com.app.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.auth.UsuarioRepository;
import com.app.auth.dto.UsuarioDto;
import com.app.auth.model.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario salvar(UsuarioDto usuarioDto) {

		Usuario usuarioExiste = usuarioRepository.findByEmail(usuarioDto.email());

		if(usuarioExiste != null) {
			throw new RuntimeException( "Email ja cadastrado");
		}

		Usuario usuario = new Usuario(usuarioDto.email(), usuarioDto.senha());

		return usuarioRepository.save(usuario);
	}

}
