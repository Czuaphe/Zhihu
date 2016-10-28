package com.czuaphe.a10_zhihu.Task;

import android.os.AsyncTask;
import android.webkit.WebView;
import android.widget.TextView;

import com.czuaphe.a10_zhihu.Http.Http;

import java.io.IOException;

/**
 * Created by Czuaphe on 2016/10/28.
 */

public class LoadNewsDetails extends AsyncTask<Integer, Void, String> {
    private TextView textView;

    public LoadNewsDetails(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(Integer... integers) {
        String newsDetails = null;

        try {
            newsDetails =  Http.getNewsDetails(integers[0]);
        } catch (IOException e) {

        }

        return newsDetails;

    }

    @Override
    protected void onPostExecute(String s) {
        textView.setText(s);
    }
}
