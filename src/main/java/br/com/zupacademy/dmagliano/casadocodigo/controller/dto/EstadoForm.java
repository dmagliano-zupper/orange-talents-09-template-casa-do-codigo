package br.com.zupacademy.dmagliano.casadocodigo.controller.dto;

public class EstadoForm {

    public String nome;
    public Long paisId;

    public EstadoForm(String nome, Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
