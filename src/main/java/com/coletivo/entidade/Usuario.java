package com.coletivo.entidade;

import java.io.Serializable;
import java.util.Date;



import com.coletivo.dto.BuscarUsuariosDTO;
import com.coletivo.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {
    

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
	private Date dataNasc;	
	private String cpf;	
	private String email;
	private String senha;
	private String telefone;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String cep;
	
	public Usuario(UsuarioDTO usuario) {
	this.nome  =usuario.nome();
	this.dataNasc = usuario.dataNasc();
	this.cpf = usuario.cpf();
	this.email = usuario.email();
	this.senha = usuario.senha();
	this.telefone = usuario.telefone();
	this.rua = usuario.rua();
	this.numero = usuario.numero();
	this.bairro = usuario.bairro();
	this.cidade = usuario.cidade();
	this.cep = usuario.cep();
	}

	public Usuario(BuscarUsuariosDTO usuarios) {
		this.id = usuarios.id();
		this.nome = usuarios.nome();
		this.dataNasc = usuarios.dataNasc();
		this.email = usuarios.email();
		this.telefone = usuarios.telefone();
		this.rua = usuarios.rua();
		this.numero = usuarios.numero();
		this.bairro = usuarios.bairro();
		this.cidade = usuarios.cidade();
		this.cep = usuarios.cep();
	}
}
