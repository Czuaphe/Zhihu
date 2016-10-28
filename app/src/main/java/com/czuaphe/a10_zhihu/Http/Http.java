package com.czuaphe.a10_zhihu.Http;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Czuaphe on 2016/10/27.
 */

public class Http {
    private static String LATEEST_NEWS = "http://news-at.zhihu.com/api/4/news/latest";
    private static String NEWSDETAILS = "http://news-at.zhihu.com/api/4/news/";

    public static String getStringfromURL(String url) throws IOException {

        HttpURLConnection conn = null;
        StringBuilder str = new StringBuilder();

        try {

            URL u = new URL(url);

            conn = (HttpURLConnection) u.openConnection();

            conn.setRequestMethod("GET");
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setDoInput(true);

            int response = conn.getResponseCode();
            if(response != HttpURLConnection.HTTP_OK) {
                Log.d("ERROR", "getStringfromURL: " + response);
            }

            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while((line = reader.readLine()) != null) {
                str.append(line);
            }

        } finally {
            if(conn != null) {
                conn.disconnect();
            }
        }
        return str.toString();
    }

    public static String getLatesetNews() throws IOException{
        return getStringfromURL(LATEEST_NEWS);
    }

    public static String getNewsDetails(int id) throws IOException{
        return getStringfromURL(NEWSDETAILS + id);
    }
}
