package br.com.curso.api.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import br.com.curso.api.entities.dto.CursoDTO;
import br.com.curso.api.mapper.CursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<List<Curso>> getAllCursos() {
		List<Curso> cursosList = cursoService.getCurso();
		return ResponseEntity.ok().body(cursosList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Curso> getCurso(@PathVariable Integer id){
		Curso curso = cursoService.getCursoById(id);

		return ResponseEntity.ok().body(curso);
	}

	@GetMapping("/pesquisaCurso")
	public ResponseEntity<List<Curso>> getCursosByNome(@RequestParam String nomeCurso){
		List<Curso> curso = cursoService.getCursoByName(nomeCurso);

		return ResponseEntity.ok().body(curso);
	}

	@PostMapping("/salvar")
	public ResponseEntity<Curso> salvarCurso(@Valid @RequestBody CursoDTO cursoDTO) throws URISyntaxException {
		Curso novoCurso = cursoService.save(mapper.toEntity(cursoDTO));

		return ResponseEntity.created(new URI(URI_SALVAR + novoCurso.getId())).body(novoCurso);
	}

}
