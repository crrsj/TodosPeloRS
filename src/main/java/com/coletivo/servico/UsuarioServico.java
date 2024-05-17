package com.coletivo.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coletivo.dto.BuscarUsuariosDTO;
import com.coletivo.dto.UsuarioDTO;
import com.coletivo.entidade.Usuario;
import com.coletivo.repositorio.UsuarioRepositorio;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServico {
	
	private final UsuarioRepositorio usuarioRepositorio;
	
	public Usuario cadastrarUsuario(UsuarioDTO usuario) {
		var cadastrar =  new Usuario(usuario);
		return usuarioRepositorio.save(cadastrar);
	}

	public List<Usuario>listarUsuarios(){
		return usuarioRepositorio.findAll();
	}
	public Usuario buscarPorId(Long id) {
		return usuarioRepositorio.findById(id).get();
	}
	
	public Usuario atualizarUsuario(BuscarUsuariosDTO usuarios,Long id) {
		var atualizar =  new Usuario(usuarios);
		atualizar.setId(id);
		return usuarioRepositorio.save(atualizar);
	}
	
	public void Excluir(Long id) {
		usuarioRepositorio.findById(id).get();
		usuarioRepositorio.deleteById(id);
	}
}
