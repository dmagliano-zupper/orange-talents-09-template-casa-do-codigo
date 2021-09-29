package br.com.zupacademy.dmagliano.casadocodigo.controller;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.LivroCadastroForm;
import br.com.zupacademy.dmagliano.casadocodigo.model.Autor;
import br.com.zupacademy.dmagliano.casadocodigo.model.Categoria;
import br.com.zupacademy.dmagliano.casadocodigo.model.Livro;
import br.com.zupacademy.dmagliano.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.dmagliano.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.dmagliano.casadocodigo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;
    @Autowired
    AutorRepository autorRepository;
    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid LivroCadastroForm livroform) {

        Livro novoLivro = new Livro(
                livroform.getTitulo(),
                livroform.getResumo(),
                livroform.getSumario(),
                livroform.getPreco(),
                livroform.getNumPaginas(),
                livroform.getIsbn(),
                livroform.getDataPublicacao(),
                livroGetCategoria(livroform.getIdCategoria()),
                livroGetAutor(livroform.getIdAutor())
        );
        livroRepository.save(novoLivro);
        return ResponseEntity.ok().build();
    }

    private Autor livroGetAutor(Long idAutor) {
        Optional<Autor> autorOptional = autorRepository.findById(idAutor);
        if (autorOptional.isPresent()) {
            return autorOptional.get();
        } else {
            return null;
        }
    }

    private Categoria livroGetCategoria(Long idCategoria) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(idCategoria);
        if (categoriaOptional.isPresent()) {
            return categoriaOptional.get();
        } else {
            return null;
        }

    }

}
