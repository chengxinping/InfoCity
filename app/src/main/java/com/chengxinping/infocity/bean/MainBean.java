package com.chengxinping.infocity.bean;

import java.util.List;

/**
 * Created by 平瓶平瓶子 on 2017/3/13.
 */

public class MainBean {
    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"nu":"70048306456243","ret_code":"0","ischeck":"1","com":"huitongkuaidi","data":[{"time":"2016-09-18 13:10:21","context":"南京市|签收|南京市【南京南航校企合作】，代理点：南航北门爱心空间站（爱心报刊亭）15757377800 已签收","ftime":"2016-09-18 13:10:21"},{"time":"2016-09-18 05:10:03","context":"南京市|派件|南京市【南京南航校企合作】，【李之山/15757377800】正在派件","ftime":"2016-09-18 05:10:03"},{"time":"2016-09-18 05:09:03","context":"南京市|到件|到南京市【南京南航校企合作】","ftime":"2016-09-18 05:09:03"},{"time":"2016-09-18 02:13:04","context":"南京市|发件|南京市【南京转运中心】，正发往【南京南航校企合作】","ftime":"2016-09-18 02:13:04"},{"time":"2016-09-17 22:22:18","context":"南京市|到件|到南京市【南京转运中心】","ftime":"2016-09-17 22:22:18"},{"time":"2016-09-17 01:15:26","context":"北京市|发件|北京市【北京转运中心】，正发往【南京转运中心】","ftime":"2016-09-17 01:15:26"},{"time":"2016-09-16 21:58:10","context":"北京市|到件|到北京市【北京转运中心】","ftime":"2016-09-16 21:58:10"},{"time":"2016-09-16 18:50:52","context":"北京市|到件|到北京市【房山分部】","ftime":"2016-09-16 18:50:52"},{"time":"2016-09-16 17:39:07","context":"北京市|收件|北京市【房山分部002】，【胡强辉/15831220133】已揽收","ftime":"2016-09-16 17:39:07"}],"state":"3","error_code":"000","error_description":"接口正常"}
     */

    private int showapi_res_code;
    private String showapi_res_error;
    private ShowapiResBodyBean showapi_res_body;

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * nu : 70048306456243
         * ret_code : 0
         * ischeck : 1
         * com : huitongkuaidi
         * data : [{"time":"2016-09-18 13:10:21","context":"南京市|签收|南京市【南京南航校企合作】，代理点：南航北门爱心空间站（爱心报刊亭）15757377800 已签收","ftime":"2016-09-18 13:10:21"},{"time":"2016-09-18 05:10:03","context":"南京市|派件|南京市【南京南航校企合作】，【李之山/15757377800】正在派件","ftime":"2016-09-18 05:10:03"},{"time":"2016-09-18 05:09:03","context":"南京市|到件|到南京市【南京南航校企合作】","ftime":"2016-09-18 05:09:03"},{"time":"2016-09-18 02:13:04","context":"南京市|发件|南京市【南京转运中心】，正发往【南京南航校企合作】","ftime":"2016-09-18 02:13:04"},{"time":"2016-09-17 22:22:18","context":"南京市|到件|到南京市【南京转运中心】","ftime":"2016-09-17 22:22:18"},{"time":"2016-09-17 01:15:26","context":"北京市|发件|北京市【北京转运中心】，正发往【南京转运中心】","ftime":"2016-09-17 01:15:26"},{"time":"2016-09-16 21:58:10","context":"北京市|到件|到北京市【北京转运中心】","ftime":"2016-09-16 21:58:10"},{"time":"2016-09-16 18:50:52","context":"北京市|到件|到北京市【房山分部】","ftime":"2016-09-16 18:50:52"},{"time":"2016-09-16 17:39:07","context":"北京市|收件|北京市【房山分部002】，【胡强辉/15831220133】已揽收","ftime":"2016-09-16 17:39:07"}]
         * state : 3
         * error_code : 000
         * error_description : 接口正常
         */

        private String nu;
        private String ret_code;
        private String ischeck;
        private String com;
        private String state;
        private String error_code;
        private String error_description;
        private List<DataBean> data;

        public String getNu() {
            return nu;
        }

        public void setNu(String nu) {
            this.nu = nu;
        }

        public String getRet_code() {
            return ret_code;
        }

        public void setRet_code(String ret_code) {
            this.ret_code = ret_code;
        }

        public String getIscheck() {
            return ischeck;
        }

        public void setIscheck(String ischeck) {
            this.ischeck = ischeck;
        }

        public String getCom() {
            return com;
        }

        public void setCom(String com) {
            this.com = com;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getError_code() {
            return error_code;
        }

        public void setError_code(String error_code) {
            this.error_code = error_code;
        }

        public String getError_description() {
            return error_description;
        }

        public void setError_description(String error_description) {
            this.error_description = error_description;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * time : 2016-09-18 13:10:21
             * context : 南京市|签收|南京市【南京南航校企合作】，代理点：南航北门爱心空间站（爱心报刊亭）15757377800 已签收
             * ftime : 2016-09-18 13:10:21
             */

            private String time;
            private String context;
            private String ftime;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
            }

            public String getFtime() {
                return ftime;
            }

            public void setFtime(String ftime) {
                this.ftime = ftime;
            }
        }
    }
}
