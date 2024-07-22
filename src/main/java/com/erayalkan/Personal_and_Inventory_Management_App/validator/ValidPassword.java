package com.erayalkan.Personal_and_Inventory_Management_App.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CustomPasswordValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Şifre en az bir büyük harf, bir küçük harf, bir rakam ve bir özel karakter içermelidir";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
