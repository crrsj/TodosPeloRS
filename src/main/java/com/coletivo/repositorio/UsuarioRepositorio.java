package com.coletivo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coletivo.entidade.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
