package br.com.zupacademy.dmagliano.casadocodigo.controller.validator;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.AutorForm;
import br.com.zupacademy.dmagliano.casadocodigo.model.Autor;
import br.com.zupacademy.dmagliano.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {

        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        AutorForm form = (AutorForm) target;
        Optional<Autor> autorExistente = autorRepository.findByEmail(form.getEmail());
        if (autorExistente.isPresent()) {
            errors.rejectValue("email", null,
                    "Já existe autor/a o email cadastrado: " + form.getEmail());
        }

    }
}
