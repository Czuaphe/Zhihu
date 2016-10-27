package com.czuaphe.a10_zhihu.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.czuaphe.a10_zhihu.R;
import com.czuaphe.a10_zhihu.Task.LoadString;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

public class MainActivity extends AppCompatActivity {

    private String StartURL = "http://news-at.zhihu.com/api/4/start-image/1080*720";
    private TextView textView;
    private DisplayImageOptions options = new DisplayImageOptions.Builder()
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.m_textView);

        new LoadString(textView).execute(StartURL);

    }
}
