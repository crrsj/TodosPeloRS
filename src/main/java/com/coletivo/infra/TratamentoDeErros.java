package com.coletivo.infra;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class TratamentoDeErros {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErros>tratabuscaPorId(){
		var erros = new MensagemDeErros(HttpStatus.NOT_FOUND,"Id não encontrado");
		return new ResponseEntity<>(erros,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>tratador400(MethodArgumentNotValidException ex){
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(TratandoErros::new).toList());		
	}
	public record TratandoErros(String campo,String mensagem) {
		public TratandoErros(FieldError erro) {
			this(erro.getField(),erro.getDefaultMessage());
		}
		

			

	}
	
}
