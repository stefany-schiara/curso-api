package br.com.curso.api.entities.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CursoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotNull
    @NotEmpty(message = "nome não pode ser vazio")
    @Size(min = 5, max = 20)
    private String nome;

    @NotBlank
    private String area;

    public CursoDTO() {
    }

    public CursoDTO(Integer id, String nome, String area) {
        this.id = id;
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
}
