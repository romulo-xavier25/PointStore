package br.com.pointsrore.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pointsrore.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
