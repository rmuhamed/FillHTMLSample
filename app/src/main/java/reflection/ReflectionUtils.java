package reflection;

import java.util.Locale;

/**
 * Created by romh on 03/03/2017.
 */

public class ReflectionUtils {
    private static final String GETTER = "getter";

    public static String getterSignatureBy(String propertyName) {
        return String.format(Locale.getDefault(), "%s%s", GETTER, propertyName);
    }
}
