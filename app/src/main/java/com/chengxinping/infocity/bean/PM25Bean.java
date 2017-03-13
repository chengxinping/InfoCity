package com.chengxinping.infocity.bean;

/**
 * Created by 平瓶平瓶子 on 2017/3/13.
 */

public class PM25Bean {

    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"pm":{"so2":5,"o3":49,"area_code":"wuhan","pm2_5":16,"primary_pollutant":"","ct":"2017-03-13 16:52:10.901","co":0.82,"area":"武汉","no2":26,"aqi":25,"quality":"优","pm10":14,"o3_8h":49}}
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
         * pm : {"so2":5,"o3":49,"area_code":"wuhan","pm2_5":16,"primary_pollutant":"","ct":"2017-03-13 16:52:10.901","co":0.82,"area":"武汉","no2":26,"aqi":25,"quality":"优","pm10":14,"o3_8h":49}
         */

        private int ret_code;
        private PmBean pm;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public PmBean getPm() {
            return pm;
        }

        public void setPm(PmBean pm) {
            this.pm = pm;
        }

        public static class PmBean {
            /**
             * so2 : 5
             * o3 : 49
             * area_code : wuhan
             * pm2_5 : 16
             * primary_pollutant :
             * ct : 2017-03-13 16:52:10.901
             * co : 0.82
             * area : 武汉
             * no2 : 26
             * aqi : 25
             * quality : 优
             * pm10 : 14
             * o3_8h : 49
             */

            private int so2;
            private int o3;
            private String area_code;
            private int pm2_5;
            private String primary_pollutant;
            private String ct;
            private double co;
            private String area;
            private int no2;
            private int aqi;
            private String quality;
            private int pm10;
            private int o3_8h;

            public int getSo2() {
                return so2;
            }

            public void setSo2(int so2) {
                this.so2 = so2;
            }

            public int getO3() {
                return o3;
            }

            public void setO3(int o3) {
                this.o3 = o3;
            }

            public String getArea_code() {
                return area_code;
            }

            public void setArea_code(String area_code) {
                this.area_code = area_code;
            }

            public int getPm2_5() {
                return pm2_5;
            }

            public void setPm2_5(int pm2_5) {
                this.pm2_5 = pm2_5;
            }

            public String getPrimary_pollutant() {
                return primary_pollutant;
            }

            public void setPrimary_pollutant(String primary_pollutant) {
                this.primary_pollutant = primary_pollutant;
            }

            public String getCt() {
                return ct;
            }

            public void setCt(String ct) {
                this.ct = ct;
            }

            public double getCo() {
                return co;
            }

            public void setCo(double co) {
                this.co = co;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public int getNo2() {
                return no2;
            }

            public void setNo2(int no2) {
                this.no2 = no2;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }

            public int getPm10() {
                return pm10;
            }

            public void setPm10(int pm10) {
                this.pm10 = pm10;
            }

            public int getO3_8h() {
                return o3_8h;
            }

            public void setO3_8h(int o3_8h) {
                this.o3_8h = o3_8h;
            }
        }
    }
}
