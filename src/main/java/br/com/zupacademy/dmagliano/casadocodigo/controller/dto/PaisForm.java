package br.com.zupacademy.dmagliano.casadocodigo.controller.dto;

import br.com.zupacademy.dmagliano.casadocodigo.controller.validator.UniqueValue;
import br.com.zupacademy.dmagliano.casadocodigo.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    @Deprecated
    public PaisForm() {
    }

    public PaisForm(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
