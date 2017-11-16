package com.thg.acger.news;

import java.util.List;

/**
 * Created by xieyongxiong on 2017/11/16.
 */

public class NewsModel {

    /**
     * code : 200
     * status : success
     * data : [{"title":"8536","image_url":["a","b"],"time":"2017-10-30","url":"a","type":"13273","other":"other"}]
     * currentPage : 1
     * totalPages : 26
     */

    private int code;
    private String status;
    private int currentPage;
    private int totalPages;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 8536
         * image_url : ["a","b"]
         * time : 2017-10-30
         * url : a
         * type : 13273
         * other : other
         */

        private String title;
        private String time;
        private String url;
        private String type;
        private String other;
        private List<String> image_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public List<String> getImage_url() {
            return image_url;
        }

        public void setImage_url(List<String> image_url) {
            this.image_url = image_url;
        }
    }
}
