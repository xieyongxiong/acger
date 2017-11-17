package com.thg.acger.news;

import java.util.List;

/**
 * Created by xieyongxiong on 2017/11/16.
 */

public class NewsModel {

    /**
     * code : 200
     * status : success
     * data : [{"id":"2","title":"话题：哪部10月新番目前让你眼前一亮","source":"腾讯动漫","url":"http://comic.qq.com/a/20171017/040420.htm","type":"0","create_time":"2017-11-17 00:00:00","other":"","image_url1":"http://inews.gtimg.com/newsapp_match/0/2171972472/0","image_url2":"","image_url3":""}]
     */

    private int code;
    private String status;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 2
         * title : 话题：哪部10月新番目前让你眼前一亮
         * source : 腾讯动漫
         * url : http://comic.qq.com/a/20171017/040420.htm
         * type : 0
         * create_time : 2017-11-17 00:00:00
         * other :
         * image_url1 : http://inews.gtimg.com/newsapp_match/0/2171972472/0
         * image_url2 :
         * image_url3 :
         */

        private String id;
        private String title;
        private String source;
        private String url;
        private String type;
        private String create_time;
        private String other;
        private String image_url1;
        private String image_url2;
        private String image_url3;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
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

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getOther() {
            return other;
        }

        public void setOther(String other) {
            this.other = other;
        }

        public String getImage_url1() {
            return image_url1;
        }

        public void setImage_url1(String image_url1) {
            this.image_url1 = image_url1;
        }

        public String getImage_url2() {
            return image_url2;
        }

        public void setImage_url2(String image_url2) {
            this.image_url2 = image_url2;
        }

        public String getImage_url3() {
            return image_url3;
        }

        public void setImage_url3(String image_url3) {
            this.image_url3 = image_url3;
        }
    }
}
