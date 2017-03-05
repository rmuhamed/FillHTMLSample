package html;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

import model.Transaction;
import reflection.ReflectionUtils;
import reflection.ReflectiveClass;
import reflection.ReflectiveMethod;

/**
 * Created by romh on 03/03/2017.
 */

public class FileParser {

    /**
     *
     * @param originalLine
     * @param tag
     * @param t
     *
     * @return
     */
    public String replace(String originalLine, String tag, Transaction t) {
        if (originalLine.contains(tag)) {
            String propertyName = this.getPropertyBy(tag);

            ReflectiveMethod method = new ReflectiveClass(Transaction.class).getterBy(propertyName);

            try {
                originalLine = originalLine.replace(tag, (String) method.invoke(t));
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return originalLine;
    }

    private String getPropertyBy(String tag) {
        StringTokenizer startTokenizer = new StringTokenizer(tag, "{{");

        StringTokenizer endTokenizer = new StringTokenizer((String) startTokenizer.nextElement(), "}}");

        return (String) endTokenizer.nextElement();
    }

}
