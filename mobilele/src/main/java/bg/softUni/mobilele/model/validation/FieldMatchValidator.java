package bg.softUni.mobilele.model.validation;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String first;
    private String second;
    private String message;


    @Override
    public void initialize(FieldMatch constraintAnnotation) {

        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();
        this.message = constraintAnnotation.message();

    }

    // in this case the value will a all UserRegisterDto
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(value);

        Object firstValue = beanWrapper.getPropertyValue(this.first);
        Object secondValue = beanWrapper.getPropertyValue(this.second);

        boolean isValid;

        if (firstValue == null) {
            isValid = secondValue == null;
        } else {
            isValid = firstValue.equals(secondValue);
        }

        if (!isValid) {
            context.buildConstraintViolationWithTemplate(message).
                    addPropertyNode(second).
                    addConstraintViolation().
                    disableDefaultConstraintViolation();
        }

        return isValid;
    }
}
