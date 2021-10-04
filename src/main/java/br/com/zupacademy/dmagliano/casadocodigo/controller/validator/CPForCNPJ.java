package br.com.zupacademy.dmagliano.casadocodigo.controller.validator;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = {})
@ConstraintComposition(CompositionType.OR)
@ReportAsSingleViolation
@CPF
@CNPJ
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CPForCNPJ {

    String message() default "Documento não informado ou inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
