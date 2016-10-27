package com.czuaphe.a10_zhihu.Task;

import android.os.AsyncTask;
import android.widget.Adapter;

import com.czuaphe.a10_zhihu.Adapter.NewsAdapter;
import com.czuaphe.a10_zhihu.Entity.News;
import com.czuaphe.a10_zhihu.Http.Http;
import com.czuaphe.a10_zhihu.Http.JSONHelper;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by Czuaphe on 2016/10/27.
 */

public class LoadNews extends AsyncTask<Void, Void, List<News> > {

    private NewsAdapter newsAdapter;

    public LoadNews(NewsAdapter newsAdapter) {
        super();
        this.newsAdapter = newsAdapter;
    }



    @Override
    protected List<News> doInBackground(Void... voids) {
        List<News> list = null;

        try {
            list =  JSONHelper.parseJSONtoList(Http.getLatesetNews());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    protected void onPostExecute(List<News> newses) {
        newsAdapter.refreshNewsList(newses);
    }
}
