package com.coletivo.infra;

import org.springframework.http.HttpStatus;

public record MensagemDeErros(HttpStatus status , String mensagem) {
 public MensagemDeErros(MensagemDeErros erros) {
	 this(erros.status,erros.mensagem);
			 
 }
}
