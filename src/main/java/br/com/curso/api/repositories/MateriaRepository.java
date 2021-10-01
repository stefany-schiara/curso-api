package br.com.curso.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.curso.api.entities.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>{

}
