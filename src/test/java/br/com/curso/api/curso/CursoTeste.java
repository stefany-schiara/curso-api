package br.com.curso.api.curso;

import br.com.curso.api.entities.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class CursoTeste {


    @Test
    void testarCursoNaoVazio(){
      Curso curso = new Curso();
      assertNotNull(curso);

    }

    @Test
    void valorDoCursoNaoNulo(){
        Curso curso = new Curso();
        assertNotNull(curso.getValorCurso());
    }

    @Test
    void testarNovoCursoValorZero(){
        Curso curso = new Curso();
        Assertions.assertEquals(new BigDecimal(0), curso.getValorCurso());
    }

    @Test
    void testarNovoCursoSemAlunos(){
        Curso curso = new Curso();
        Assertions.assertTrue(curso.getAlunos().isEmpty());
    }



}
