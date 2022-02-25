package br.com.curso.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


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
	
	@PrePersist
	private void antesDePersistirDados() {
		this.usuario = "Admin";
	}
	
	@PostPersist
	private void aposPersistirDados() {
		this.nome = this.nome + " POST";
	}	

	public Curso() {
		super();
	}

	public Curso(String nome, String area) {
		super();
		this.nome = nome;
		this.area = area;
	}

	public Integer getId() {
		return id;
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
