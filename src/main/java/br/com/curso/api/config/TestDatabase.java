package br.com.curso.api.config;

import br.com.curso.api.entities.Curso;
import br.com.curso.api.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class TestDatabase implements CommandLineRunner {

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public void run(String... args) throws Exception {

        Curso curso1 = new Curso("Graduação em TI", "Exatas");
        Curso curso2 = new Curso("Graduação em Economia", "Humanas");
        Curso curso3 = new Curso("Graduacao em Administração", "Humanas");
        Curso curso4 = new Curso("Graduação em Educação Física", "Humanas");

        cursoRepository.save(curso1);
        cursoRepository.save(curso2);
        cursoRepository.save(curso3);
        cursoRepository.save(curso4);
    }
}
