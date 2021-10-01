# curso-api

API:

O que é: Application Programming Interface - Interface de Programação de Aplicação - Ou seja, é um conjunto de normas que possibilita a comunicação, troca de informações entre plataformas.


Endpoint:

Na tradução literal significa o "ponto final", que é o caminho onde você irá disponibilizar o acesso à sua aplicação.
Você disponibiliza vários pontos(endpoints) para:
- Consultar informações(GET)
- Alterar informações(PUT)
- Inserir informações(POST)
- Deletar informações(DELETE)


@RestController - Anotação usada para classes(componentes) de controladores para projetos serviçoes RESTFul, nada mais é do que o mesmo que anotar uma classe com:
@Controller + @ResponseBody

@RequestMapping - Anotação usada para mapear o caminho da classe que possui as requisições.
Exemplo:
```
@RestController
@RequestMapping("/teste")
public class TesteController {

}
```

@GetMapping - Anotação usada para mapear uma requisição do tipo HTTP GET. Basicamente é um atalho para você não ter que usar assim:
@RequestMapping(method = RequestMethod.GET)
Exemplo:
```
@RestController
@RequestMapping("/teste")
public class TesteController {

	@GetMapping("/oi")
	public String getOi() {
		return "Oi Pessoal!";
	}
	
}
```
Ou seja, para acessar a requisição específica, a url ficaria: http://localhost:8080/teste/oi
Na classe acima, podemos dizer que temos um endpoint.

ResponseEntity - Utilizado para retornar uma resposta mais completa. Representa toda resposta HTTP. Você pode controlar: status(http status), cabeçalho(header) e corpo(body).
```
@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	private ResponseEntity<List<Curso>> getCursos() {
		List<Curso> cursosList = cursoService.getCurso();
		
		return ResponseEntity.ok().body(cursosList);
	}

}
```
