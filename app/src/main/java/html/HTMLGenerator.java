package html;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Transaction;

import static html.TemplateInfo.HTML_FILE_URI;
import static html.TemplateInfo.TAGs.AMOUNT;
import static html.TemplateInfo.TAGs.IBAN;
import static html.TemplateInfo.TAGs.RECIPIENT;
import static html.TemplateInfo.TAGs.SUBJECT;
import static html.TemplateInfo.TAGs.TOTAL_AMOUNT;

/**
 * Created by romh on 02/03/2017.
 */

public class HTMLGenerator {

    public String fromO2BankingSEPATemplate(Context context, Transaction dummyTransaction) {
        StringBuilder htmlFile = new StringBuilder("");

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(context.getAssets().open(HTML_FILE_URI)));
            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                mLine = new FileParser().replace(mLine, IBAN, dummyTransaction);
                mLine = new FileParser().replace(mLine, AMOUNT, dummyTransaction);
                mLine = new FileParser().replace(mLine, SUBJECT, dummyTransaction);
                mLine = new FileParser().replace(mLine, RECIPIENT, dummyTransaction);
                mLine = new FileParser().replace(mLine, TOTAL_AMOUNT, dummyTransaction);

                //process line
                htmlFile.append(mLine);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {}
            }
        }

        String result = htmlFile.toString();

        return result;
    }

    public String getO2BankingSepaTemplateFromAssets() {
        String htmlFile = "file:///android_asset/templates/o2banking_sepa_template.html";

        return htmlFile;
    }

    public String getO2BankingSepaTemplateFromRawString() {
        String htmlFile = "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>O2 Banking Template</title>\n" +
                "\n" +
                "    <style kind=\"text/css\">\n" +
                "\n" +
                "body { \n" +
                "  font-family: helvetica, arial, sans-serif;\n" +
                "  font-size: 16px;\n" +
                "  font-weight: 400;\n" +
                "  text-rendering: optimizeLegibility;\n" +
                "}\n" +
                "\n" +
                "div.header-right {\n" +
                "\ttext-align: right;\n" +
                "}\n" +
                "\n" +
                "div.table-title {\n" +
                "  display: block;\n" +
                "  margin: auto;\n" +
                "  padding:5px;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                ".table-title h3 {\n" +
                "   color: #000000;\n" +
                "   font-size: 20px;\n" +
                "   font-weight: 400;\n" +
                "   font-style:normal;\n" +
                "   font-family: helvetica, arial, sans-serif; \n" +
                "}\n" +
                "\n" +
                "\n" +
                "/*** Table Styles **/\n" +
                "\n" +
                ".table-fill {\n" +
                "  background: white;    \n" +
                "  margin: auto;\n" +
                "  padding:5px;\n" +
                "  width: 100%; \n" +
                "}\n" +
                " \n" +
                "th {\n" +
                "  color:#000000;;\n" +
                "  background:#CCCCCC;  \n" +
                "  font-size:16px;\n" +
                "  font-weight: bold;\n" +
                "  padding:4px;\n" +
                "  text-align:left;\n" +
                "  vertical-align:middle;\n" +
                "}\n" +
                " \n" +
                "  \n" +
                "tr {\n" +
                "  font-size:16px;\n" +
                "  font-weight:normal; \n" +
                "}\n" +
                " \n" +
                " \n" +
                " \n" +
                "td {\n" +
                "  background:#FFFFFF;\n" +
                "  text-align:left;\n" +
                "  vertical-align:middle;\n" +
                "  font-size:14px;\n" +
                "}\n" +
                "\n" +
                " \n" +
                "\n" +
                "th.text-left {\n" +
                "  text-align: left;\n" +
                "}\n" +
                "\n" +
                "th.text-center {\n" +
                "  text-align: center;\n" +
                "}\n" +
                "\n" +
                "th.text-right {\n" +
                "  text-align: right;\n" +
                "}\n" +
                "\n" +
                "td.text-left {\n" +
                "  text-align: left;\n" +
                "}\n" +
                "\n" +
                "td.text-center {\n" +
                "  text-align: center;\n" +
                "}\n" +
                "\n" +
                "td.text-right {\n" +
                "  text-align: right;\n" +
                "}\n" +
                "\n" +
                "img.logo {\n" +
                "\twidth: 200px;\n" +
                "\talign:middle;\n" +
                "}\n" +
                "\n" +
                "@media screen {\n" +
                "    div.divFooter {\n" +
                "        display: none;\n" +
                "    }\n" +
                "}\n" +
                "@media print {\n" +
                "    div.divFooter {\n" +
                "        font-size:12px;\n" +
                "        position: fixed;\n" +
                "        bottom: 0;\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "\n" +
                "    </style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "\n" +
                "<div style=\"text-align: center\">\n" +
                "    <img alt=\"logo\" class=\"logo\"\n" +
                "         src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAq8AAACPCAYAAADUUjKCAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAA3ppVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTM4IDc5LjE1OTgyNCwgMjAxNi8wOS8xNC0wMTowOTowMSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0ieG1wLmRpZDo0NzM2YWY0Ni0yZmFmLTRlZGUtODY2OS01ZDQ5MzYzMTMyYjYiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6MzNEQzVENURCNTZBMTFFNjlEQ0E5NENDQThGMkZBMjYiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6MzNEQzVENUNCNTZBMTFFNjlEQ0E5NENDQThGMkZBMjYiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUuNSAoTWFjaW50b3NoKSI+IDx4bXBNTTpEZXJpdmVkRnJvbSBzdFJlZjppbnN0YW5jZUlEPSJ4bXAuaWlkOjQ3MzZhZjQ2LTJmYWYtNGVkZS04NjY5LTVkNDkzNjMxMzJiNiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo0NzM2YWY0Ni0yZmFmLTRlZGUtODY2OS01ZDQ5MzYzMTMy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\"/>\n" +
                "</div>\n" +
                "<h3>Umsatzauskunft O2 Banking Konto</h3>\n" +
                "<p>9. Februar 2017 um 20:27</p>\n" +
                "\n" +
                "\n" +
                "<div class=\"table-title\">\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "<table class=\"table-fill\">\n" +
                "    <thead>\n" +
                "    <tr>\n" +
                "        <th class=\"text-left\">Buchung</th>\n" +
                "        <th class=\"text-left\">Wert</th>\n" +
                "        <th class=\"text-left\">Art</th>\n" +
                "        <th class=\"text-left\">Verwendungszweck und Empfänger</th>\n" +
                "        <th class=\"text-right\">Umsatz in €</th>\n" +
                "    </tr>\n" +
                "    </thead>\n" +
                "    <tbody>\n" +
                "    <tr>\n" +
                "        <td class=\"text-left\">08.02.2017</td>\n" +
                "        <td class=\"text-left\">08.02.2017</td>\n" +
                "        <td class=\"text-left\">Überweisung</td>\n" +
                "        <td class=\"text-left\">Herzlichen Dank für das AngeboteBay Kauf vom 07.02.2017 <br>\n" +
                "            Freuen uns auf die Lieferung<br>\n" +
                "            an: <strong>TITLE FIRST LAST NAME RECIPIENT</strong><br>\n" +
                "            DE00 1234 1234 1234 1234 12<br>\n" +
                "        </td>\n" +
                "        <td class=\"text-right\">{{amount}}</td>\n" +
                "    </tr>\n" +
                "\n" +
                "    </tbody>\n" +
                "</table>\n" +
                "<div class=\"divFooter\">O2 Banking – Ein Service der Fidor Bank AG, Sandstr. 33, 80335 München</div>\n" +
                "</body>\n";

        return htmlFile;
    }

}
