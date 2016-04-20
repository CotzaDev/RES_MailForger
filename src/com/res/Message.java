/**
 -----------------------------------------------------------------------------------
 Laboratoire : <nn>
 Fichier     : Message.java
 Auteur(s)   : Andrea Cotza
 Date        : 20.04.2016
 
 But         : <‡ complÈter>
 
 Remarque(s) : <‡ complÈter>
 
 Compilateur : jdk1.8.0_60
 -----------------------------------------------------------------------------------
*/

package com.res;

public class Message {

    private String title;
    private String subj;
    private String msg;

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
