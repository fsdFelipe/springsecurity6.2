package com.app.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.auth.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Usuario findByEmail(String email);

}
