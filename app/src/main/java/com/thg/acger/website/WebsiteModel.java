package com.thg.acger.website;

/**
 * Created by xieyongxiong on 2017/11/17.
 */

public class WebsiteModel {
    String webName;
    String webNetIconUrl;
    String weblocalIconUrl;

    public WebsiteModel(String webName, String webNetIconUrl, String weblocalIconUrl) {
        this.webName = webName;
        this.webNetIconUrl = webNetIconUrl;
        this.weblocalIconUrl = weblocalIconUrl;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getWebNetIconUrl() {
        return webNetIconUrl;
    }

    public void setWebNetIconUrl(String webNetIconUrl) {
        this.webNetIconUrl = webNetIconUrl;
    }

    public String getWeblocalIconUrl() {
        return weblocalIconUrl;
    }

    public void setWeblocalIconUrl(String weblocalIconUrl) {
        this.weblocalIconUrl = weblocalIconUrl;
    }
}
