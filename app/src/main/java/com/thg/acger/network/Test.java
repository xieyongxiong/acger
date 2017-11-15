package com.thg.acger.network;

import java.util.List;

/**
 * Created by baidu on 2017/9/21.
 */

public class Test {

    /**
     * retCode : 0
     * retMsg : success
     * data : [{"uuid":"123123124213","nickName":"jim","pic":"http://url/1.jpg","age":18,"gender":"female"},{"uuid":"645473123124213","nickName":"jack","pic":"http://url/2.jpg","age":18,"gender":"female"}]
     * hasMore : false
     */

    private int retCode;
    private String retMsg;
    private boolean hasMore;
    private List<DataBean> data;

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uuid : 123123124213
         * nickName : jim
         * pic : http://url/1.jpg
         * age : 18
         * gender : female
         */

        private String uuid;
        private String nickName;
        private String pic;
        private int age;
        private String gender;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
}
