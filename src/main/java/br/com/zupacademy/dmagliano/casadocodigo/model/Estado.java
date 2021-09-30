package br.com.zupacademy.dmagliano.casadocodigo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    @ManyToOne
    @JoinColumn(name = "pais_id")
    public Pais pais;

    public Estado(String name, Pais pais) {
        this.nome = name;
        this.pais = pais;
    }

    @Deprecated
    public Estado() {
    }

    public String getName() {
        return nome;
    }

    public Pais getPais() {
        return pais;
    }
}
