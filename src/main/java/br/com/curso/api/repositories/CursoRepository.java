package br.com.curso.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.curso.api.entities.Curso;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer>{

    List<Curso> findByNomeContaining(String nomeCurso);
}
