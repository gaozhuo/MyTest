package com.example.webviewtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.d("gaozhuo", "title=" + title);
            }
        });
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d("gaozhuo", "title2=" + view.getTitle());

            }
        });
        WebSettings webSettings = mWebView.getSettings();
        String useragent = webSettings.getUserAgentString();
        Log.d("gaozhuo", "useragent=" + useragent);
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www.baidu.com/");
        //mWebView.loadUrl("http://120.24.94.126:80/community/web/#/login/4820fc1961fe460685b5f2dec5bcd030");

    }
}
