package just4test.yml;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.PARAMETER,ElementType.FIELD})
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ValidateGZCB {
    DataType dataType();
    int limit() default 0;
    NecessaryEnum necessary() default NecessaryEnum.N;

    enum NecessaryEnum {
        Y, N
    }

    enum DataType {
        NUMBER, CHARACTER, NUMBER_AND_CHARACTER, DICTIONARY,AMOUNT,DATE
    }
}
