package bg.softUni.mobilele.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Means that this annotation will be active and stay in runTime
@Retention(RetentionPolicy.RUNTIME)
//with TYPE means we can used to class
@Target(ElementType.TYPE)
// Class which will get validation
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface FieldMatch {

    String first();

    String second();

    String message() default "Passwords dont match!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
