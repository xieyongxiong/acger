package com.thg.acger.web;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thg.acger.R;

public class WebContentActivity extends AppCompatActivity {

    private WebView newsConetent;
    private String contentUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        newsConetent = (WebView) findViewById(R.id.news_content_container);
        Intent intent = getIntent();
        contentUrl = intent.getStringExtra("url");
        newsConetent.getSettings().setJavaScriptEnabled(true);
        newsConetent.loadUrl(contentUrl);
        newsConetent.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }

        });
//        newsConetent.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
//            }
//        });
    }
    @Override
    public void onPause() {
        super.onPause();
        newsConetent.onPause();
        newsConetent.pauseTimers();
    }

    @Override
    public void onResume() {
        super.onResume();
        newsConetent.resumeTimers();
        newsConetent.onResume();
    }


    @Override
    protected void onDestroy() {
        newsConetent.destroy();
        newsConetent = null;
        super.onDestroy();
    }
}
