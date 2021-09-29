package br.com.zupacademy.dmagliano.casadocodigo.model;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.LivroCadastroForm;
import br.com.zupacademy.dmagliano.casadocodigo.controller.validator.UniqueValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @DecimalMin(value = "20.00")
    private BigDecimal preco;
    @Min(value = 100)
    private Integer numPaginas;

    @Size(max = 13)
    private String isbn;

    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo, String resumo, String sumario,
                 BigDecimal preco, Integer numPaginas, String isbn,
                 LocalDate dataPublicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

}
