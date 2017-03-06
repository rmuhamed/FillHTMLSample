package com.gft.agmobile.samples;

import android.content.Context;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;
import java.io.InputStream;

import generator.TransactionGenerator;
import html.HTMLGenerator;
import html.O2SepaTemplateInfo;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();

    public static final String MIME_TYPE = "text/HTML";
    public static final String ENCODING = "UTF-8";

    public static final String jobName = "PDFDummyDocument";
    private O2SepaTemplateInfo templateInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.templateInfo = this.getTemplateInfo();

        this.doWebViewPrint();
    }

    private void doWebViewPrint() {
        // Create a WebView object specifically for printing
        WebView webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient() {

            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                createWebPrintJob(view);
            }
        });

        webView.loadDataWithBaseURL(null,
                new HTMLGenerator().fromHTMLTemplate(this.openTemplate(), this.templateInfo.getTags(), TransactionGenerator.dummyInstance()),
                MIME_TYPE,
                ENCODING,
                null);
    }

    private O2SepaTemplateInfo getTemplateInfo() {
        return new O2SepaTemplateInfo();
    }

    private void createWebPrintJob(WebView webView) {
        // Get a PrintManager instance
        PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);
        // Get a print adapter instance
        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();
        // Create a print job with name and adapter instance
        printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());
    }

    private InputStream openTemplate() {
        InputStream htmlStream = null;
        try {
            htmlStream = this.getAssets().open(this.templateInfo.getHtmlFileUri());
        } catch (IOException e) {
            Log.e(TAG, e.toString());
        }

        return htmlStream;
    }
}
