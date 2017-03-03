package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by romh on 03/03/2017.
 */

public class ReflectionUtils {

    public static final String GET = "get";
    private final Class aClass;
    private Object instanceOf;

    public ReflectionUtils(Class aClass) {
        this.aClass = aClass;
    }

    public List<Method> getters() {
        return Arrays.asList(this.aClass.getMethods());
    }

    public Method getterBy(String propertyName) {
        String methodName = this.getterSignatureBy(propertyName);

        Method result = null;
        List<Method> getters = this.getters();

        for (Method method : getters) {
            if (method.getName().equalsIgnoreCase(methodName)) {
                result = method;
                break;
            }
        }

        return result;
    }

    public String getterSignatureBy(String propertytName) {
        return String.format(Locale.getDefault(), "%s%s", GET, propertytName);
    }

    /**
     *
     * @param method
     * @param instanceOf
     */
    public Object execute(Method method, Object instanceOf) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(instanceOf, null);
    }
}
