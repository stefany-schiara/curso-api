package br.com.curso.api.mapper;

import br.com.curso.api.entities.Curso;
import br.com.curso.api.entities.dto.CursoDTO;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso toEntity(CursoDTO cursoDTO){

        Curso curso = new Curso();

        curso.setNome(cursoDTO.getNome());
        curso.setArea(cursoDTO.getArea());

        return curso;
    }
}
