package com.example.demo;
/*This class is checking if the Enum of the State is valid and print an error if needed
 * Leonid Mazarsky
 * 18-12-2021
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EnumStatePatternValidator implements ConstraintValidator<EnumStates,Enum<?>> {
    private Pattern pattern;

    @Override
    public void initialize(EnumStates annotation) {
        try {
            pattern = Pattern.compile(annotation.regexp());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        Matcher m = pattern.matcher(value.name());
        return m.matches();
    }
}
