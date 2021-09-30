package br.com.zupacademy.dmagliano.casadocodigo.controller;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.EstadoForm;
import br.com.zupacademy.dmagliano.casadocodigo.controller.validator.ProibeEstadoDuplicadoPaisValidator;
import br.com.zupacademy.dmagliano.casadocodigo.model.Estado;
import br.com.zupacademy.dmagliano.casadocodigo.model.Pais;
import br.com.zupacademy.dmagliano.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.dmagliano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    PaisRepository paisRepository;
    @Autowired
    ProibeEstadoDuplicadoPaisValidator proibeEstadoDuplicadoPaisValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(proibeEstadoDuplicadoPaisValidator);
    }


    @PostMapping
    public ResponseEntity cadastro(@RequestBody @Valid EstadoForm estadoForm) {

        Estado novoEstado = toEntity(estadoForm);
        estadoRepository.save(novoEstado);
        return ResponseEntity.ok().build();
    }

    private Estado toEntity(EstadoForm estadoForm) {

        Optional<Pais> pais = paisRepository.findById(estadoForm.getPaisId());
        Estado estadoCriado = new Estado(
                estadoForm.getNome(),
                pais.get()
        );
        return estadoCriado;
    }
}
