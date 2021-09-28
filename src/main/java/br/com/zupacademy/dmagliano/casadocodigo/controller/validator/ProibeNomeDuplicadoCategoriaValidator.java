package br.com.zupacademy.dmagliano.casadocodigo.controller.validator;

import br.com.zupacademy.dmagliano.casadocodigo.controller.dto.CategoriaForm;
import br.com.zupacademy.dmagliano.casadocodigo.model.Categoria;
import br.com.zupacademy.dmagliano.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeNomeDuplicadoCategoriaValidator implements Validator {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> clazz) {

        return CategoriaForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        CategoriaForm form = (CategoriaForm) target;
        Optional<Categoria> categoriaExistente = categoriaRepository.findByNome(form.getNome());
        if (categoriaExistente.isPresent()){
            errors.rejectValue("nome", null, "Categoria já cadastrada com o nome " + form.getNome());
        }
    }
}
