package br.com.zupacademy.dmagliano.casadocodigo.controller.dto;

import br.com.zupacademy.dmagliano.casadocodigo.model.Autor;
import br.com.zupacademy.dmagliano.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalheDTO {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer numPaginas;
    private String isbn;
    private LocalDate dataPublicacao;
    private String categoria;
    private AutorDetalheDTO autorDetalhe;

    public LivroDetalheDTO(String titulo, String resumo, String sumario,
                           BigDecimal preco, Integer numPaginas, String isbn,
                           LocalDate dataPublicacao, String categoria, AutorDetalheDTO autorDetalhe) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autorDetalhe = autorDetalhe;
    }

    public LivroDetalheDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numPaginas = livro.getNumPaginas();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = livro.getCategoria().getNome();
        this.autorDetalhe = Autor.getDetalhe(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public AutorDetalheDTO getAutorDetalhe() {
        return autorDetalhe;
    }
}
