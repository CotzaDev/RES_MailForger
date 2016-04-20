package com.res;

import java.util.List;
import java.util.ArrayList;

public class Mail {
    String from;
    List<String> to = new ArrayList<String>();
    String msg;

    public String getFrom() {
        return from;
    }

    public List<String> getTo() {
        return to;
    }

    public String getHeader() {
        String header = "";
        header+="From: <"+from+">\n";
        for(String str : to)
            header+="To: <"+str+">\n";

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
