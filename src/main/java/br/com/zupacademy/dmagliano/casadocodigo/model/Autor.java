package br.com.zupacademy.dmagliano.casadocodigo.model;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.AutorDetalheDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @Column(length = 400)
    private String descricao;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Autor() {
    }

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }


    public static AutorDetalheDTO getDetalhe(Autor autor) {
        return new AutorDetalheDTO(autor);
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
