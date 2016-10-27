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

    public static String getStringfromURL(URL url) throws IOException {

        HttpURLConnection conn = null;
        StringBuilder str = new StringBuilder();

        try {
            conn = (HttpURLConnection) url.openConnection();

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
}
