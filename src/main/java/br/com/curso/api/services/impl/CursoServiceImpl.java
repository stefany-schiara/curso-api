package br.com.curso.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.api.entities.Curso;
import br.com.curso.api.repositories.CursoRepository;
import br.com.curso.api.services.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public List<Curso> getCurso() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Curso getCursoById(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElse(null);
	}

}
