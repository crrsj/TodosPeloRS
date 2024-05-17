package com.coletivo.dto;

import java.util.Date;

import com.coletivo.entidade.Usuario;

public record BuscarUsuariosDTO( 
	Long id,
	String nome,
	Date dataNasc,
	String email,
	String telefone,
	String rua,
	String numero,
	String bairro,
	String cidade,
	String cep) {
	
	public BuscarUsuariosDTO(Usuario usuario) {
		this(
				usuario.getId(),
				usuario.getNome(),
				usuario.getDataNasc(),
				usuario.getEmail(),
				usuario.getTelefone(),
				usuario.getRua(),
				usuario.getNumero(),
				usuario.getBairro(),
				usuario.getCidade(),
				usuario.getCep());
		
	}
}
