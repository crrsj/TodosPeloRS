package com.coletivo.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coletivo.dto.BuscarUsuariosDTO;
import com.coletivo.dto.UsuarioDTO;
import com.coletivo.servico.UsuarioServico;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("usuario")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioControle {
	private final UsuarioServico usuarioServico;

	
	@PostMapping
   @Operation(summary = "Rota responsável pelo cadastro de usuários") 
    @ApiResponse(responseCode = "201",description = "usuário cadastrado com sucesso",content = {
   		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<UsuarioDTO>cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuario){
		var cadastrar = usuarioServico.cadastrarUsuario(usuario);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("usuario/{id}")
	    .buildAndExpand(cadastrar.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDTO(cadastrar));
	}
	
	@GetMapping
	@Operation(summary = "Rota responsável pela busca de todos os usuários")
	@ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	   })           
	public ResponseEntity<List<BuscarUsuariosDTO>>listar(){
		var listar = usuarioServico.listarUsuarios().stream().map(BuscarUsuariosDTO::new).toList();
		return ResponseEntity.ok(listar);
	}
	
      @GetMapping("{id}")
	  @Operation(summary = "Rota responsável por buscar um usuário pelo id")
		 @ApiResponse(responseCode = "200",description = " sucesso",content = {
		    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
		  })         		
	public 	ResponseEntity<BuscarUsuariosDTO>buscarPorId(@PathVariable Long id){
		var buscaId = usuarioServico.buscarPorId(id);
		
		return ResponseEntity.ok().body(new BuscarUsuariosDTO(buscaId));
	}
	
	@PutMapping("{id}")
	 @Operation(summary = "Rota responsável por atualizar um usuário pelo id")
	 @ApiResponse(responseCode = "200",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	  })         		
	public ResponseEntity<BuscarUsuariosDTO>atualizarUsuario(@RequestBody  BuscarUsuariosDTO usuarios,@PathVariable Long id){
		var atualize = usuarioServico.atualizarUsuario(usuarios, id);
		return ResponseEntity.ok().body(new BuscarUsuariosDTO(atualize));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Rota responsável por deletar usuário pelo id")
	@ApiResponse(responseCode = "204",description = " sucesso",content = {
	    		@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
	    })           
	public ResponseEntity<Void>excluirUsuario(@PathVariable Long id){
		usuarioServico.Excluir(id);
		return ResponseEntity.noContent().build();
	}
}
