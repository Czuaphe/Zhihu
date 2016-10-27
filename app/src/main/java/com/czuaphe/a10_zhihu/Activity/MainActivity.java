package com.czuaphe.a10_zhihu.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.czuaphe.a10_zhihu.Adapter.NewsAdapter;
import com.czuaphe.a10_zhihu.Entity.News;
import com.czuaphe.a10_zhihu.R;
import com.czuaphe.a10_zhihu.Task.LoadNews;
import com.czuaphe.a10_zhihu.Task.LoadString;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

public class MainActivity extends AppCompatActivity {

    private String StartURL = "http://news-at.zhihu.com/api/4/start-image/1080*720";
    private TextView textView;


    private ListView listView;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textView = (TextView) findViewById(R.id.m_textView);

        //new LoadString(textView).execute();

        listView = (ListView) findViewById(R.id.m_listView);
        newsAdapter = new NewsAdapter(this, R.layout.news_item);
        listView.setAdapter(newsAdapter);

        new LoadNews(newsAdapter).execute();

    }
}
