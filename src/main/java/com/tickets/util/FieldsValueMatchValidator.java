package com.tickets.util;

import com.tickets.annotation.FieldsValueMatch;
import com.tickets.model.dto.UserRequestDto;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class FieldsValueMatchValidator
        implements ConstraintValidator<FieldsValueMatch, UserRequestDto> {

    private String field;
    private String fieldMatch;

    public void initialize(FieldsValueMatch constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();
    }

    public boolean isValid(UserRequestDto userRequestDto, ConstraintValidatorContext context) {

        Object fieldValue = new BeanWrapperImpl(userRequestDto).getPropertyValue(field);
        Object fieldMatchValue = new BeanWrapperImpl(userRequestDto).getPropertyValue(fieldMatch);
        
        if (fieldValue != null) {
            return fieldValue.equals(fieldMatchValue);
        } else {
            return fieldMatchValue == null;
        }
    }
}
