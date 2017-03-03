package com.gft.agmobile.samples;

import android.content.Context;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import html.HTMLDummy;
import html.MyJavaScriptInterface;

public class MainActivity extends AppCompatActivity {
    public static final String MIME_TYPE = "text/HTML";
    public static final String ENCODING = "UTF-8";

    public static final String jobName = "PDFDumyDocument";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        //webView.loadUrl(new HTMLDummy().getO2BankingSepaTemplateFromAssets());
        //webView.loadDataWithBaseURL(null, new HTMLDummy().getO2BankingSepaTemplateFromRawString(), MIME_TYPE, ENCODING, null);

        webView.loadDataWithBaseURL(null, new HTMLDummy().getO2BankingSepaTemplate(this), MIME_TYPE, ENCODING, null);
    }


    @android.webkit.JavascriptInterface
    private void createWebPrintJob(WebView webView) {
        // Get a PrintManager instance
        PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);

        // Get a print adapter instance
        PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();

        // Create a print job with name and adapter instance

        PrintJob printJob = printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());

        printJob.isCompleted();
    }
}
