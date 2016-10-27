package com.czuaphe.a10_zhihu.Entity;

import java.io.Serializable;

/**
 * Created by Czuaphe on 2016/10/27.
 */

public class News implements Serializable{
    private String title;
    private int id;
    private String image;

    public News() {}

    public News(int id, String title, String image) {
        this.id = id;
        this.image = image;
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getImage() {
        return this.image;
    }

}
