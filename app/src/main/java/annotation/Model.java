package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by romh on 03/03/2017.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Model {
    String returnType();
    String name();
    String kind();
}
