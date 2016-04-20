package com.res;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Class who manage and abstract a mail
 */
public class Mail {
    String from;
    List<String> to;
    String subj;
    String msg;

    Mail() {
        this.from = "";
        this.to = new ArrayList<String>();
        this.subj = "";
        this.msg = "";
    }

    Mail(String from, List<String> to, String subj, String msg) {
        this.from = from;
        this.to = to;
        this.subj = subj;
        this.msg = msg;
    }

    public String getFrom() {
        return from;
    }

    public List<String> getTo() {
        return to;
    }

    public String getHeader() {
        String header = "";
        header += "From: <" + from + ">\r\n";
        for (String str : to)
            header += "To: <" + str + ">\r\n";

        Date dDate = new Date();
        DateFormat dFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
        header += "Date: " + dFormat.format(dDate) + "\r\n";

        header += "Subject: " + subj + "\r\n";

        return header;
    }

    public String getSubj() {
        return subj;
    }

    public String getMsg() {
        return msg;
    }

    public void setTo(List lst) {
        to = lst;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSubj(String subj) {
        this.subj = subj;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
