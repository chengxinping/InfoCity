package com.chengxinping.infocity.bean;

import java.util.List;

/**
 * Created by 平瓶平瓶子 on 2017/3/13.
 */

public class BusBean {


    /**
     * showapi_res_code : 0
     * showapi_res_error :
     * showapi_res_body : {"ret_code":0,"retList":[{"stats":"南湖大道茶山刘;民族大道纺织大学;民族大道中南民族大学;民族大道当代学生公寓;民族大道上钱村;民族大道光谷广场;珞喻路鲁巷;珞喻路吴家湾;珞喻路科技会展中心;珞喻路马家庄;珞喻路卓刀泉;珞喻路广埠屯;武珞路街道口;武珞路丁字桥;武珞路傅家坡客运站;中山路大东门;武昌火车站综合体","name":"538路(南湖大道茶山刘-武昌火车站综合体)","info":"首末车:6:20-21:45;高等级车 单一票价2元,刷卡1.60元"},{"stats":"武昌火车站综合体;中山路大东门;武珞路大东门;武珞路傅家坡客运站;武珞路丁字桥;武珞路地铁宝通寺站;武珞路街道口;珞喻路广埠屯;珞喻路卓刀泉;卓刀泉南路虎泉;虎泉街地铁虎泉站;虎泉街交通学院;虎泉街民政学院;虎泉街下马庄;虎泉街地铁杨家湾站;虎泉街化工学院;虎泉街地铁光谷广场站;民族大道光谷广场;民族大道上钱村;民族大道时间广场;民族大道中南民族大学;民族大道纺织大学;南湖大道茶山刘","name":"538路(武昌火车站综合体-南湖大道茶山刘)","info":"5:30-21:00|南湖大道茶山刘：6:20-21:45;高等级车 单一票价2元，刷卡1.60元。"}]}
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
         * retList : [{"stats":"南湖大道茶山刘;民族大道纺织大学;民族大道中南民族大学;民族大道当代学生公寓;民族大道上钱村;民族大道光谷广场;珞喻路鲁巷;珞喻路吴家湾;珞喻路科技会展中心;珞喻路马家庄;珞喻路卓刀泉;珞喻路广埠屯;武珞路街道口;武珞路丁字桥;武珞路傅家坡客运站;中山路大东门;武昌火车站综合体","name":"538路(南湖大道茶山刘-武昌火车站综合体)","info":"首末车:6:20-21:45;高等级车 单一票价2元,刷卡1.60元"},{"stats":"武昌火车站综合体;中山路大东门;武珞路大东门;武珞路傅家坡客运站;武珞路丁字桥;武珞路地铁宝通寺站;武珞路街道口;珞喻路广埠屯;珞喻路卓刀泉;卓刀泉南路虎泉;虎泉街地铁虎泉站;虎泉街交通学院;虎泉街民政学院;虎泉街下马庄;虎泉街地铁杨家湾站;虎泉街化工学院;虎泉街地铁光谷广场站;民族大道光谷广场;民族大道上钱村;民族大道时间广场;民族大道中南民族大学;民族大道纺织大学;南湖大道茶山刘","name":"538路(武昌火车站综合体-南湖大道茶山刘)","info":"5:30-21:00|南湖大道茶山刘：6:20-21:45;高等级车 单一票价2元，刷卡1.60元。"}]
         */

        private int ret_code;
        private List<RetListBean> retList;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public List<RetListBean> getRetList() {
            return retList;
        }

        public void setRetList(List<RetListBean> retList) {
            this.retList = retList;
        }

        public static class RetListBean {
            /**
             * stats : 南湖大道茶山刘;民族大道纺织大学;民族大道中南民族大学;民族大道当代学生公寓;民族大道上钱村;民族大道光谷广场;珞喻路鲁巷;珞喻路吴家湾;珞喻路科技会展中心;珞喻路马家庄;珞喻路卓刀泉;珞喻路广埠屯;武珞路街道口;武珞路丁字桥;武珞路傅家坡客运站;中山路大东门;武昌火车站综合体
             * name : 538路(南湖大道茶山刘-武昌火车站综合体)
             * info : 首末车:6:20-21:45;高等级车 单一票价2元,刷卡1.60元
             */

            private String stats;
            private String name;
            private String info;

            public String getStats() {
                return stats;
            }

            public void setStats(String stats) {
                this.stats = stats;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }
        }
    }
}
