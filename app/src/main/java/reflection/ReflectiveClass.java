package reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rmuhamed on 5/3/17.
 */

public class ReflectiveClass {
    private final Class aClass;

    public ReflectiveClass(Class aClass) {
        this.aClass = aClass;
    }

    private List<ReflectiveMethod> getters() {
        List<ReflectiveMethod> getters = new ArrayList<>();
        List<Method> methods = Arrays.asList(this.aClass.getMethods());

        for (Method aMethod : methods) {
            ReflectiveMethod reflectiveMethod = new ReflectiveMethod(aMethod);
            if (reflectiveMethod.isGetter()) {
                getters.add(reflectiveMethod);
            }
        }

        return getters;
    }

    public ReflectiveMethod getterBy(String propertyName) {
        ReflectiveMethod result = null;

        List<ReflectiveMethod> getters = this.getters();

        for (ReflectiveMethod aGetter : getters) {
            if (aGetter.getName().equalsIgnoreCase(propertyName)) {
                result = aGetter;
            }
        }

        return result;
    }
}
