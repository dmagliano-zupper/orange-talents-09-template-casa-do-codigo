package br.com.zupacademy.dmagliano.casadocodigo.controller.dto;

import br.com.zupacademy.dmagliano.casadocodigo.controller.validator.UniqueValue;
import br.com.zupacademy.dmagliano.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroCadastroForm {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Length(max = 500)
    private String resumo;
    private String sumario;
    @DecimalMin(value = "20.00")
    @NumberFormat(pattern = "##,00")
    private BigDecimal preco;
    @Min(value = 100)
    private Integer numPaginas;

    @Size(min = 13, max = 13)
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    private Long idCategoria;

    private Long idAutor;


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

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

}
