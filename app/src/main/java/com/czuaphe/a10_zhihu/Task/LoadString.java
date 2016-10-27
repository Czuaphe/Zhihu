package com.czuaphe.a10_zhihu.Task;

import com.czuaphe.a10_zhihu.Http.Http;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Czuaphe on 2016/10/27.
 */

public class LoadString extends AsyncTask<Void, Void, String> {

    private TextView textView;

    public LoadString(TextView textView) {
        super();
        this.textView = textView;
    }


    @Override
    protected String doInBackground(Void... voids) {
        try {
            return Http.getLatesetNews();
        } catch (IOException e) {
            return "URL may be invalid";
        }
    }


    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);

        textView.setText(s);
    }
}
