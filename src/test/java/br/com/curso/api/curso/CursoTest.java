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
        System.out.println("[USANDO JUNIT] - Classe de teste Curso iniciando...");
    }

    @BeforeEach
    void antesDeCadaMetodo(){
        System.out.println("[USANDO JUNIT] - Antes de cada método...");
        curso = new Curso();
    }

    @AfterEach
    void depoisDeCadaMetodo(){
        System.out.println("[USANDO JUNIT] - Nome do Curso " + curso.getNome());
    }

    @AfterAll
    void depoisDeTudo(){
        System.out.println("[USANDO JUNIT] - Classe de teste finalizada...");
    }

    @Test
    void testarCursoNaoVazio() {
        System.out.println("[USANDO JUNIT] - testarCursoNaoVazio");
        assertNotNull(curso);
    }

    @Test
    void valorDoCursoNaoNulo() {
        System.out.println("[USANDO JUNIT] - valorDoCursoNaoNulo");
        assertNotNull(curso.getValorCurso());
    }

    @Test
    void testarNovoCursoValorZero() {
        System.out.println("[USANDO JUNIT] - testarNovoCursoValorZero");
        Assertions.assertEquals(new BigDecimal(0), curso.getValorCurso());
    }

    @Test
    void testarNovoCursoSemAlunos() {
        System.out.println("[USANDO JUNIT] - testarNovoCursoSemAlunos");
        Assertions.assertTrue(curso.getAlunos().isEmpty());
    }


}
