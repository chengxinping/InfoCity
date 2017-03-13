package com.chengxinping.infocity.bean;

import java.util.List;

/**
 * Created by 平瓶平瓶子 on 2017/3/13.
 */

public class OilBean {
    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"list":[{"prov":"湖北","p90":"5.93","p0":"6.12","p95":"7.00","p97":"7","p89":"5.4","p92":"6.54","p93":"6.54","ct":"2017-03-13 07:02:04.972"}]}
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
         * ret_code : 0
         * list : [{"prov":"湖北","p90":"5.93","p0":"6.12","p95":"7.00","p97":"7","p89":"5.4","p92":"6.54","p93":"6.54","ct":"2017-03-13 07:02:04.972"}]
         */

        private int ret_code;
        private List<ListBean> list;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * prov : 湖北
             * p90 : 5.93
             * p0 : 6.12
             * p95 : 7.00
             * p97 : 7
             * p89 : 5.4
             * p92 : 6.54
             * p93 : 6.54
             * ct : 2017-03-13 07:02:04.972
             */

            private String prov;
            private String p90;
            private String p0;
            private String p95;
            private String p97;
            private String p89;
            private String p92;
            private String p93;
            private String ct;

            public String getProv() {
                return prov;
            }

            public void setProv(String prov) {
                this.prov = prov;
            }

            public String getP90() {
                return p90;
            }

            public void setP90(String p90) {
                this.p90 = p90;
            }

            public String getP0() {
                return p0;
            }

            public void setP0(String p0) {
                this.p0 = p0;
            }

            public String getP95() {
                return p95;
            }

            public void setP95(String p95) {
                this.p95 = p95;
            }

            public String getP97() {
                return p97;
            }

            public void setP97(String p97) {
                this.p97 = p97;
            }

            public String getP89() {
                return p89;
            }

            public void setP89(String p89) {
                this.p89 = p89;
            }

            public String getP92() {
                return p92;
            }

            public void setP92(String p92) {
                this.p92 = p92;
            }

            public String getP93() {
                return p93;
            }

            public void setP93(String p93) {
                this.p93 = p93;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }
        }
    }
}
