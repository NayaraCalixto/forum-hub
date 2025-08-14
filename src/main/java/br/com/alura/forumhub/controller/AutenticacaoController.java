package br.com.alura.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forumhub.dto.DadosAutenticacao;
import br.com.alura.forumhub.model.usuario.Usuario;
import br.com.alura.forumhub.service.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
	private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> afetuarLogin(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
		var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
		Authentication authentication = manager.authenticate(token);

		return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));
	}

}
