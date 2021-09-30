package br.com.zupacademy.dmagliano.casadocodigo.controller.validator;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.EstadoForm;
import br.com.zupacademy.dmagliano.casadocodigo.model.Estado;
import br.com.zupacademy.dmagliano.casadocodigo.model.Pais;
import br.com.zupacademy.dmagliano.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.dmagliano.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEstadoDuplicadoPaisValidator implements Validator {

    @Autowired
    EstadoRepository estadoRepository;
    @Autowired
    PaisRepository paisRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        EstadoForm form = (EstadoForm) target;
        Optional<Pais> pais = paisRepository.findById(form.getPaisId());
        if (pais.isPresent()) {
            Optional<Estado> estadoExistente = estadoRepository.findByNomeAndPaisId(form.getNome(), form.getPaisId());
            if (estadoExistente.isPresent()) {
                errors.rejectValue("paisId", null,
                        "Já existe estado " + form.getNome()+ " cadastrado para este pais: " + pais.get().getNome());
            }
        } else {
            errors.rejectValue("paisId", null,
            "Não existe país cadastrado para este Id: " + form.getPaisId());
        }
    }
}
