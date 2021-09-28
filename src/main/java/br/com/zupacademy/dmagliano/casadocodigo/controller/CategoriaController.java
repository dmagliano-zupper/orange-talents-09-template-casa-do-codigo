package br.com.zupacademy.dmagliano.casadocodigo.controller;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.CategoriaForm;
import br.com.zupacademy.dmagliano.casadocodigo.controller.validator.ProibeNomeDuplicadoCategoriaValidator;
import br.com.zupacademy.dmagliano.casadocodigo.model.Categoria;
import br.com.zupacademy.dmagliano.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProibeNomeDuplicadoCategoriaValidator proibeNomeDuplicadoCategoriaValidator;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(proibeNomeDuplicadoCategoriaValidator);
    }

    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid CategoriaForm categoriaForm){
        Categoria categoria = categoriaForm.toEntity();
        categoriaRepository.save(categoria);

        return ResponseEntity.ok().build();
    }


}
