package com.thg.acger.news;

import java.util.List;

/**
 * Created by xieyongxiong on 2017/11/16.
 */

public class NewsItem extends NewsModel.DataBean {
    private String title;
    private String time;
    private String url;
    private String type;
    private String other;
    private List<String> image_url;

    public NewsItem(String title, String time, String url, String type, String other, List<String> image_url) {
        this.title = title;
        this.time = time;
        this.url = url;
        this.type = type;
        this.other = other;
        this.image_url = image_url;
    }
}
