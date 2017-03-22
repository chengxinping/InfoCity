package com.chengxinping.infocity.bean;

import java.io.Serializable;
import java.util.Date;

public class MessageBean implements Serializable {

    private Type type;
    private Date time;
    private int code;
    private String text;
    private String url;

    public enum Type {
        INCOMING, OUTCOMING
    }

    public MessageBean() {
    }

    public MessageBean(Type type, Date time) {
        this.type = type;
        this.time = time;
    }

    public MessageBean(Type type, Date time, String text) {
        this.type = type;
        this.time = time;
        this.text = text;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "type=" + type +
                ", time=" + time +
                ", code=" + code +
                ", text='" + text + '\'' +
                ", url='" + url +
                '}';
    }
}