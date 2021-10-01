package br.com.curso.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.curso.api.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
