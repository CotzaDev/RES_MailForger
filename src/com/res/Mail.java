package com.res;

import java.util.List;

public class Mail {
    String from;
    List<String> to;
    String msg;

    public String getFrom() {
        return from;
    }

    public List getTo() {
        return to;
    }

    public String getHeader() {
        String header = "";

        return header;
    }

    public String getMsg() {
        return msg;
    }

    public void setTo(List lst) {
        to = lst;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
