package br.com.zupacademy.dmagliano.casadocodigo.controller;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.PaisForm;
import br.com.zupacademy.dmagliano.casadocodigo.model.Pais;
import br.com.zupacademy.dmagliano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @PostMapping
    public ResponseEntity cadastra(@RequestBody @Valid PaisForm paisForm){

        Pais paisCriado = new Pais(paisForm);
        paisRepository.save(paisCriado);

        return ResponseEntity.ok().build();
    }

}
