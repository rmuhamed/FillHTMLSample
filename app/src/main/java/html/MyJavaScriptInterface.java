package html;

import android.text.Html;
import android.util.Log;

/**
 * Created by romh on 02/03/2017.
 */

public class MyJavaScriptInterface {

    @SuppressWarnings("unused")
    public void processHTML(final String html) {
        Log.i("processed html", html);

        Thread outerThread = new Thread(new Runnable() {

            @Override
            public void run() {

                String oAuthDetails=null;
                oAuthDetails = Html.fromHtml(html).toString();
                Log.i("oAuthDetails",oAuthDetails);

            }
        });

        outerThread.start();
    }
}
