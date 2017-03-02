package html;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.Html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by romh on 02/03/2017.
 */

public class HTMLDummy {

    //String htmlFile = "file:///android_asset/templates/o2banking_sepa_template.html";

    public String getO2BankingSepaTemplate(Context context) {
        StringBuilder htmlFile = new StringBuilder("");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open("templates/o2banking_sepa_template.html"), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                htmlFile.append(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }

        return htmlFile.toString();
    }

}
