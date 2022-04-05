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
---------------------------------------

Para definir perfis diferentes, por exemplo, 
executar o  sistema apontando para ambientes diferentes(dev, uat, prd)

Devemos criar um arquivo properties para cada perfil. ex:

application-dev.properties
application-uat.properties
application-prd.properties

o arquivo application.properties é o principal do projeto e é nele que será setado
para qual arquivo deverá apontar.

o application.properties ficaria assim:

```
spring.profiles.active=dev
```

É possivel verificar qual profile está sendo executado no console ao startar o projeto:

![img.png](img.png)

__________________________________________________________________________
@Profile - Anotação para definir em que profile(dev, uat, prd, local) uma classe é executada. 
Para definir uma classe que será executada ao rodar o programa de acordo com o profile, podemos criar uma classe
da seguinte maneira:

```
@Profile("local")
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
```

Ao rodar a aplicação setando profile local, essa classe será executada, realizando insert na tabela.

strategy de criacao (cria tabelas ao rodar o projeto)
```
spring.jpa.hibernate.ddl-auto=create
```
Para não ficar criando as tabelas todas as vezes, basta setar desta forma:
```
spring.jpa.hibernate.ddl-auto=none
```

@BeforeAll - Ao anotar um método na classe de teste com essa annotation, o método será executado
antes de tudo o que estiver na classe.
Ex:
```
@BeforeAll
    void antesDeTudo() {
        System.out.println("Classe de teste Cuso iniciando...");
    }
```
Quando utilizada essa annotation, o método deverá ser static, ou a classe deverá ser anotada com @TestInstance(Lifecycle.PER_CLASS)
isso quer dizer que que o ciclo de vida será executado por classe.
Ex:
```
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CursoTest {
}
```



@BeforeEach - Ao anotar um método na classe de teste com essa annotation, antes de cada método executado
o método anotado será executado.
Ex: 
```
 @BeforeEach
    void antesDeCadaMetodo(){
        System.out.println("Antes de cada método...");
        curso = new Curso();
    }
```

@AfterEach - Ao anotar um método na classe de teste com essa annotation, após cada método executado
o método anotado será executado.
Ex:
```
 @AfterEach
    void depoisDeCadaMetodo(){
        System.out.println("[USANDO JUNIT] - Nome do Curso " + curso.getNome());
    }
```

@AfterAll - Ao anotar um método na classe de teste com essa annotation, no final da execução de toda classe
o método anotado será executado.
Ex:
```
@AfterAll
    void depoisDeTudo(){
        System.out.println("[USANDO JUNIT] - Classe de teste finalizada...");
    }
```

@PathVariable - Utilizado para passar um valor através da URL da aplicação. 
Ex:
```
@GetMapping("/{id}")
	public ResponseEntity<Curso> getCurso(@PathVariable Integer id){
		Curso curso = cursoService.getCursoById(id);

		return ResponseEntity.ok().body(curso);
	}
```
URL do endpoint ficará assim: http://localhost:8080/cursos/1


findById - Utilizado para buscar um elemento através do id.
Para utilizar esse método nativo do JPA, ele exige um tipo Optional no retorno.
Basta realizar na camada de serviço da seguinte forma.
Ex:
```
@Service
public class CursoServiceImpl implements CursoService {

    @Override
        public Curso getCursoById(Integer id) {
            Optional<Curso> curso = cursoRepository.findById(id);
            return curso.orElse(null);
        }
	}
```
Esse orElse é um metódo que vai retornar ou um valor, no caso um objeto do tipo curso,
caso não encontre nada com o id passado, retorna nulo.



@RequestParam - Utilizado para passar um valor por parametro através da URL da aplicação.
Diferente do @PathVariable que passamos o valor diretamente na url, neste caso, passamos 
o símbolo ? e tudo que vier após, são parametros, porem, passamos nomeParametro=valorParametro.
Ex:
```
@GetMapping("/pesquisaCurso")
	public ResponseEntity<List<Curso>> getCursosByNome(@RequestParam String nomeCurso){
		List<Curso> curso = cursoService.getCursoByName(nomeCurso);

		return ResponseEntity.ok().body(curso);
	}
```
URL do endpoint ficará assim: http://localhost:8080/cursos/pesquisaCurso?nomeCurso=http://localhost:8080/cursos/pesquisaCurso?nomeCurso=Educação


@PutMapping - Utilizado para criar um endpoint para realizar update em registros. 
Ex:
```
@PutMapping("alterar/{id}")
	public ResponseEntity<Curso> alterarCurso(@Valid @RequestBody CursoDTO cursoDTO, @PathVariable Integer id) throws URISyntaxException {

		Curso cursoAlterado = mapper.toEntity(cursoDTO);
		cursoAlterado.setId(id);
		cursoService.updateCurso(cursoAlterado);

		return ResponseEntity.noContent().build();
	}
```
URL do endpoint ficará assim: http://localhost:8080/cursos/alterar/1
Nós passamos o id do registro, pois vamos buscar o registro antes de alterá-lo.
Para passar os novos dados do registro, temos que passar o body. Todo método post(inclusão) e put(atualização)
possuem body. No caso abaixo, vou mudar nome e área de um curso
```
{
   "nome": "Curso de id 1 alterado",
   "area": "Exatas"
}
```

A camada de serviço ficará da seguinte maneira
```
@Override
public void updateCurso(Curso curso) {
Curso cursoASerAtualizado = this.findById(curso.getId());

        cursoASerAtualizado.setNome(curso.getNome());
        cursoASerAtualizado.setArea(curso.getArea());

        cursoRepository.save(cursoASerAtualizado);
    }
```
Ou seja, busca um curso existente e atualiza com os novos dados.

@DeleteMapping - Utilizado para criar um endpoint para realizar deleção de registros.
Ex:
```
@DeleteMapping("/deletar/{id}")
	public ResponseEntity<HttpStatus> deletarCurso(@PathVariable Integer id) throws URISyntaxException {
		cursoService.deleteById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
```
URL do endpoint ficará assim: http://localhost:8080/cursos/deletar/1

Lembrando que para cada tipo de requisição Http, devemos passar na api que chama os endpoints
por exemplo o Postman, ao criar o request, temos que setar o tipo de verbo(get, put, post, delete) 
na ferramenta. Caso chamarmos um endpoint e setarmos o verbo errado, o sistema apresentará o erro:
405: Method not allowed.
