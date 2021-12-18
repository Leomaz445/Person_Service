package com.example.demo;
/*This is an annotation type Class for the persons Gender -MALE/FEMALE/OTHER
 * Leonid Mazarsky
 * 18-12-2021
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = EnumGenderPatternValidator.class)
public @interface EnumGender {
    String regexp();
    String message() default "must match \"{regexp}\"";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
