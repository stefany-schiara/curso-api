package br.com.curso.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import br.com.curso.api.entities.dto.CursoDTO;
import br.com.curso.api.mapper.CursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.api.entities.Curso;
import br.com.curso.api.services.CursoService;

import javax.validation.Valid;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	private static String URI_SALVAR = "/cursos/salvar/";

	@Autowired
	private CursoService cursoService;

	@Autowired
	private CursoMapper mapper;

	@GetMapping
	public ResponseEntity<List<Curso>> getCursos() {
		List<Curso> cursosList = cursoService.getCurso();
		return ResponseEntity.ok().body(cursosList);
	}

	@PostMapping("/salvar")
	public ResponseEntity<Curso> salvarCurso(@Valid @RequestBody CursoDTO cursoDTO) throws URISyntaxException {
		Curso novoCurso = cursoService.save(mapper.toEntity(cursoDTO));

		return ResponseEntity.created(new URI(URI_SALVAR + novoCurso.getId())).body(novoCurso);


	}

}
