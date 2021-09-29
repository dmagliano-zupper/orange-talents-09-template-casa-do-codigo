package br.com.zupacademy.dmagliano.casadocodigo.controller.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {

    String message() default "Campo com valor semelhante já cadastrado";

    Class<?>[] groups() default {}; //grupos para aplicar a regra

    Class<? extends Payload>[] payload() default {}; //payload para envir informação extra

    String fieldName();

    Class<?> domainClass();

}
