package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import annotation.Model;

/**
 * Created by rmuhamed on 5/3/17.
 */

public class ReflectiveMethod {
    private static final String GETTER = "getter";
    private static final String SETTER = "setter";

    private final Method method;

    public ReflectiveMethod(Method method) {
        this.method = method;
    }

    public boolean isGetter() {
        return this.hasAnnotation()
                && ((Model) this.method.getAnnotations()[0]).kind().equals(GETTER);
    }

    public boolean isSetter() {
        return this.hasAnnotation()
                && ((Model) this.method.getAnnotations()[0]).kind().equals(SETTER);
    }

    public boolean hasAnnotation() {
        Annotation[] annotations = this.method.getAnnotations();

        return annotations!=null && annotations.length>0;
    }

    public String getName() {
        return ((Model) this.method.getAnnotations()[0]).name();
    }

    /**
     * Invoke getter of an instance
     * @param anInstanceOf
     * @return getter result
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public Object invoke(Object anInstanceOf) throws InvocationTargetException, IllegalAccessException {
        return this.method.invoke(anInstanceOf, null);
    }

    public Object invoke(Object instance, Object... args) throws InvocationTargetException, IllegalAccessException {
        return this.method.invoke(instance, args);
    }
}
