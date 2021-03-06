package com.res;

public class Message {

    private String title;
    private String subj;
    private String msg;

    Message() {
        this.title = "";
        this.subj = "";
        this.msg = "";
    }

    Message(String title, String subj, String msg) {
        this.title = title;
        this.subj = subj;
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public String getSubj() {
        return subj;
    }

    public String getMsg() {
        return msg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubj(String subj) {
        this.subj = subj;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
