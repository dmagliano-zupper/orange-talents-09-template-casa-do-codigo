package br.com.zupacademy.dmagliano.casadocodigo.controller.dto;

import br.com.zupacademy.dmagliano.casadocodigo.model.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaForm {

    @NotBlank
    @JsonProperty
    private String nome;

    public CategoriaForm() {
    }

    public CategoriaForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria toEntity() { return new Categoria(this.nome);}
}
