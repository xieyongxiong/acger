package com.thg.acger.comic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.thg.acger.R;

public class ComicActivity extends AppCompatActivity {

    private WebView newsConetent;
    private String contentUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic);
        newsConetent = (WebView) findViewById(R.id.news_content_container);
        Intent intent = getIntent();
        contentUrl = intent.getStringExtra("url");
        newsConetent.getSettings().setJavaScriptEnabled(true);
        newsConetent.loadUrl(contentUrl);
        newsConetent.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(contentUrl);
                return true;
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
