package br.com.curso.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@GetMapping
	private String getCursos() {
		return "Endpoint para os cursos!";
	}

}
