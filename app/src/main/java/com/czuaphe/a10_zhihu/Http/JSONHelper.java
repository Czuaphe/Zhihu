package com.czuaphe.a10_zhihu.Http;

import com.czuaphe.a10_zhihu.Entity.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Czuaphe on 2016/10/27.
 */

public class JSONHelper {
    public static List<News> parseJSONtoList(String json) throws JSONException{
        List<News> newsList = new ArrayList<>();
        JSONObject newsContent = new JSONObject(json);
        JSONArray newsArray = newsContent.getJSONArray("stories");

        for(int i = 0; i < newsArray.length(); i ++) {

            JSONObject newsObject = newsArray.getJSONObject(i);
            int id = newsObject.optInt("id");
            String title = newsObject.optString("title");
            String image = "";

            if(newsObject.has("images")) {
                image = (String) newsObject.getJSONArray("images").get(0);
            }

            News news = new News(id, title, image);
            newsList.add(news);
        }
        return newsList;

    }
}
