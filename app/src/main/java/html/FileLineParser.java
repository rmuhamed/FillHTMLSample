package html;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

import model.Transaction;
import reflection.ReflectionUtils;

/**
 * Created by romh on 03/03/2017.
 */

public class FileLineParser {


    public String replace(String originalLine, String tag, Transaction t) {
        if (originalLine.contains(tag)) {
            String propertyName = this.getPropertyBy(tag);

            ReflectionUtils reflectionUtils = new ReflectionUtils(Transaction.class);

            Method method = reflectionUtils.getterBy(propertyName);

            try {
                String stringValue = (String) reflectionUtils.execute(method, t);

                originalLine = originalLine.replace(tag, stringValue);

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
