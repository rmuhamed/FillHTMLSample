package html;

import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.StringTokenizer;

import model.Transaction;
import reflection.ReflectiveClass;
import reflection.ReflectiveMethod;

/**
 * Created by romh on 03/03/2017.
 */

public class FileParser {

    public static final String TAG = FileParser.class.getSimpleName();

    /**
     *
     * @param originalLine
     * @param tags
     * @param t
     *
     * @return
     */
    public String replace(String originalLine, List<String> tags, Transaction t) {
        for (String tag: tags) {
            if (originalLine.contains(tag)) {
                String propertyName = this.getPropertyBy(tag);

                ReflectiveMethod method = new ReflectiveClass(Transaction.class).getterBy(propertyName);

                try {
                    originalLine = originalLine.replace(tag, method.invoke(t).toString());
                } catch (InvocationTargetException | IllegalAccessException e) {
                    Log.e(TAG, e.toString());
                }
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
