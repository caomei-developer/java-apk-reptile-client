package com.charles.data.baidu.data;

import java.io.Serializable;

public class BaiduJson implements Serializable {

    public String title;
    public String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
