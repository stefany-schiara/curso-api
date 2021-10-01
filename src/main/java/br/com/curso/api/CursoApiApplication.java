package br.com.curso.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.curso.api.entities.Curso;
import br.com.curso.api.repositories.CursoRepository;

@SpringBootApplication
public class CursoApiApplication implements CommandLineRunner {

	@Autowired
	CursoRepository cursoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursoApiApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Curso curso1 = new Curso("Graduação em TI", "Exatas");
		Curso curso2 = new Curso("Graduação em Economia", "Humanas");
		Curso curso3 = new Curso("Graduacao em Administração", "Humanas");
		Curso curso4 = new Curso("Graduação em Educação Física", "Humanas");		
		Curso curso5 = new Curso("Graduação em Educação Continuada", "Humanas");
		Curso curso6 = new Curso("Graduação em educação Física", "Exatas");
		
		cursoRepository.save(curso1);
		cursoRepository.save(curso2);
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);
		cursoRepository.save(curso5);
		cursoRepository.save(curso6);
	}

}
