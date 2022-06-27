package bg.softUni.mobilele.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Means that this annotation will be active and stay in runTime
@Retention(RetentionPolicy.RUNTIME)
// Can annotate a field with this annotation.
@Target(ElementType.FIELD)
// Class which will get validation
@Constraint(validatedBy = UniqueUserEmailValidator.class)
public @interface UniqueUserEmail {

    String message() default "Invalid email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
