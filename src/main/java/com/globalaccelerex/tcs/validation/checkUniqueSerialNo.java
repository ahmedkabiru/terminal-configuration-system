package com.globalaccelerex.tcs.validation;

import com.globalaccelerex.tcs.validation.impl.SerialNoValidator;
import com.globalaccelerex.tcs.validation.impl.TerminalIDValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SerialNoValidator.class)
@Documented
public @interface checkUniqueSerialNo {
    String message() default "Serial No already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
