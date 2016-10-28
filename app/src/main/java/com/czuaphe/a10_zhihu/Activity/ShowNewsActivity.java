package com.czuaphe.a10_zhihu.Activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.czuaphe.a10_zhihu.Entity.News;
import com.czuaphe.a10_zhihu.R;
import com.czuaphe.a10_zhihu.Task.LoadNewsDetails;

/**
 * Created by Czuaphe on 2016/10/28.
 */

public class ShowNewsActivity extends Activity {

    private WebView webView;
    private TextView textView;
    private News news;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news);

        webView = (WebView)findViewById(R.id.m_webView);
        webView.getSettings().setJavaScriptEnabled(true);

        textView = (TextView)findViewById(R.id.m_textView);

        news = (News) getIntent().getSerializableExtra("news");

        new LoadNewsDetails(textView).execute(news.getId());

    }

}
