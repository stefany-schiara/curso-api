package br.com.curso.api.services;

import java.util.List;

import br.com.curso.api.entities.Curso;

public interface CursoService {
	
	public List<Curso> getCurso();
	public Curso save(Curso curso);
	public Curso findById(Integer id);
	public List<Curso> getCursoByName(String nomeCurso);
	public void updateCurso(Curso curso);

}
