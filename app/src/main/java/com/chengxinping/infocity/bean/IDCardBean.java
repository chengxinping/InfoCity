package com.chengxinping.infocity.bean;

/**
 * Created by 平瓶平瓶子 on 2017/3/13.
 */

public class IDCardBean {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"errNum":0,"ret_code":0,"retMsg":"success","retData":{"birthday":"1995-06-15","sex":"M","address":"湖北武汉市新洲区"}}
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
         * errNum : 0
         * ret_code : 0
         * retMsg : success
         * retData : {"birthday":"1995-06-15","sex":"M","address":"湖北武汉市新洲区"}
         */

        private int errNum;
        private int ret_code;
        private String retMsg;
        private RetDataBean retData;

        public int getErrNum() {
            return errNum;
        }

        public void setErrNum(int errNum) {
            this.errNum = errNum;
        }

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public String getRetMsg() {
            return retMsg;
        }

        public void setRetMsg(String retMsg) {
            this.retMsg = retMsg;
        }

        public RetDataBean getRetData() {
            return retData;
        }

        public void setRetData(RetDataBean retData) {
            this.retData = retData;
        }

        public static class RetDataBean {
            /**
             * birthday : 1995-06-15
             * sex : M
             * address : 湖北武汉市新洲区
             */

            private String birthday;
            private String sex;
            private String address;

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }
        }
    }
}
