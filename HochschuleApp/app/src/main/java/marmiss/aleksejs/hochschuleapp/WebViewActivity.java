package marmiss.aleksejs.hochschuleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.web);
        String linkpdf = getIntent().getStringExtra("item");
        String link = getIntent().getStringExtra("link");
        String url = "http://drive.google.com/viewerng/viewer?embedded=true&url=";
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.getSettings().setAllowFileAccess(true);
        if(getIntent().getStringExtra("item") !=null) {
            webView.loadUrl(url + linkpdf);
        }else{
            webView.loadUrl(link);
        }
    }
}
