package br.com.zupacademy.dmagliano.casadocodigo.controller.dto;

import br.com.zupacademy.dmagliano.casadocodigo.model.Autor;

public class AutorDetalheDto {

    private String nome;
    private String descricao;

    @Deprecated
    public AutorDetalheDto() {
    }

    public AutorDetalheDto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public AutorDetalheDto(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
