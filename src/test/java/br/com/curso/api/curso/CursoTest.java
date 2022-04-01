package br.com.curso.api.curso;

import br.com.curso.api.entities.Curso;
import br.com.curso.api.services.CursoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CursoTest {

    @Autowired
    CursoService cursoService;

    Curso curso;

    @BeforeAll
    void antesDeTudo() {
        System.out.println("Classe de teste Cuso iniciando...");
    }

    @BeforeEach
    void antesDeCadaMetodo(){
        System.out.println("Antes de cada método...");
        curso = new Curso();
    }

    @Test
    void testarCursoNaoVazio() {
        System.out.println("método 1");
        assertNotNull(curso);
    }

    @Test
    void valorDoCursoNaoNulo() {
        System.out.println("método 2");
        assertNotNull(curso.getValorCurso());
    }

    @Test
    void testarNovoCursoValorZero() {
        System.out.println("método 3");
        Assertions.assertEquals(new BigDecimal(0), curso.getValorCurso());
    }

    @Test
    void testarNovoCursoSemAlunos() {
        System.out.println("método 4");
        Assertions.assertTrue(curso.getAlunos().isEmpty());
    }


}
