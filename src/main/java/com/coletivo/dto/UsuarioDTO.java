package com.coletivo.dto;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.coletivo.entidade.Usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(
		@NotBlank(message = "Não pode estar em branco ou nulo !")
		String nome,
		@NotNull
		Date dataNasc,
		@NotBlank(message = "Não pode estar em branco ou nulo !")	
		@CPF
		String cpf,
		@NotBlank(message = "Não pode estar em branco ou nulo!")
		@Email
		String email,
		@NotBlank(message = "Não pode estar em branco ou nulo !")
		String senha,
		@NotBlank(message = "Não pode estar em branco ou nulo !")
		String telefone,
		@NotBlank(message = "Não pode estar em branco ou nulo !")
		String rua,
		@NotBlank(message = "Não pode estar em branco ou nulo !")
		String numero,
		@NotBlank(message = "Não pode estar em branco ou nulo !")
		String bairro,
		@NotBlank(message = "Não pode estar em branco ou nulo !")
		String cidade,
		@NotBlank(message = "Não pode estar em branco ou nulo !")
		String cep) {

	public UsuarioDTO(Usuario cadastrar) {
		this(
				cadastrar.getNome(),
				cadastrar.getDataNasc(),
				cadastrar.getCpf(),
				cadastrar.getEmail(),
				cadastrar.getSenha(),
				cadastrar.getTelefone(),
				cadastrar.getRua(),
				cadastrar.getNumero(),
				cadastrar.getBairro(),
				cadastrar.getCidade(),
				cadastrar.getCep());
	}

}
