package br.com.curso.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "curso_faculdade")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curso")
	private Integer id;

	@Column(name = "nome_curso", nullable = false)
	private String nome;
	
	@Column(name = "area", nullable = false)
	private String area;

	@Column
	private BigDecimal valorCurso;
	
	@Column(name = "dt_criacao")
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataCriacao;
		
	@Column(name = "dt_atualizacao")
	@UpdateTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataAtualizacao;
	
	@Column(name = "usuario")
	@NotNull(message = "O campo usuário não pode ser nulo")
	@NotBlank(message = "O valor do campo usuário não pode branco")
	private String usuario;	
	
	@Transient
	private BigDecimal calculoValorCurso;
	
	@OneToMany(mappedBy = "curso")	
	private List<Aluno> alunos = new ArrayList<>();
	
//	@PrePersist
//	private void antesDePersistirDados() {
//		this.usuario = "Admin";
//	}
//
//	@PostPersist
//	private void aposPersistirDados() {
//		this.nome = this.nome + " POST";
//	}

	public Curso() {
		super();
		this.valorCurso = new BigDecimal(0);
	}

	public Curso(String nome, String area) {
		super();
		this.nome = nome;
		this.area = area;
	}

	public Integer getId() {
		return id;
	}

	public BigDecimal getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(BigDecimal valorCurso) {
		this.valorCurso = valorCurso;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}	
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}		

	public BigDecimal getCalculoValorCurso() {
		return calculoValorCurso;
	}

	public void setCalculoValorCurso(BigDecimal calculoValorCurso) {
		this.calculoValorCurso = calculoValorCurso;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nome=" + nome + ", area=" + area + "]";
	}	

}
