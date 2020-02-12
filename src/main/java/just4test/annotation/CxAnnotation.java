package just4test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD,ElementType.TYPE})
@Retention(value= RetentionPolicy.CLASS)
public @interface CxAnnotation {
    String lover();
}
