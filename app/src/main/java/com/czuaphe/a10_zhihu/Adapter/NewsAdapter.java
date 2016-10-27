package com.czuaphe.a10_zhihu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.czuaphe.a10_zhihu.Entity.News;
import com.czuaphe.a10_zhihu.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by Czuaphe on 2016/10/27.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    private int resource;
    private LayoutInflater mInflater;


    public NewsAdapter(Context context, int resource) {

        super(context, resource);
        this.mInflater = LayoutInflater.from(context);
        this.resource = resource;

    }



    public NewsAdapter(Context context, int resource, List<News> objects) {

        super(context, resource, objects);
        mInflater = LayoutInflater.from(context);
        this.resource = resource;

    }

    class ViewHolder {
        ImageView imageView;
        TextView textView;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

         DisplayImageOptions options = new DisplayImageOptions.Builder()
                .build();

        if(convertView == null) {
            convertView = mInflater.inflate(resource, null);
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) convertView.findViewById(R.id.news_title);
            viewHolder.imageView = (ImageView)convertView.findViewById(R.id.news_image);
            convertView.setTag(viewHolder);

        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        News news = getItem(position);
        viewHolder.textView.setText(news.getTitle());
        ImageLoader.getInstance().displayImage(news.getImage(), viewHolder.imageView, options);
        return convertView;

    }

    public void refreshNewsList(List<News> newsList) {
        clear();
        addAll(newsList);
        notifyDataSetChanged();
    }
}
