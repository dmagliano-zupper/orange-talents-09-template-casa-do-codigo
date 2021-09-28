package br.com.zupacademy.dmagliano.casadocodigo.controller;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.AutorForm;
import br.com.zupacademy.dmagliano.casadocodigo.model.Autor;
import br.com.zupacademy.dmagliano.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    AutorRepository autorRepository;

    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid AutorForm autorForm){

        String emailAutor = autorForm.getEmail();

        if (autorRepository.existsByEmail(emailAutor)==true) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else {
            Autor autor = autorForm.toEntity();
            autorRepository.save(autor);

            return ResponseEntity.ok().build();
        }
    }
}
