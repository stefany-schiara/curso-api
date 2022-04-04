package br.com.curso.api.services;

import java.util.List;

import br.com.curso.api.entities.Curso;

public interface CursoService {
	
	public List<Curso> getCurso();
	public Curso save(Curso curso);
	public Curso getCursoById(Integer id);

}
