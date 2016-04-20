package com.res;

import java.util.List;

public class GroupOfVictim {
    private List<String> recipient;
    private String sender;

    public void setRecipient(List<String> aSublist) {
        recipient = aSublist;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getRecipient(){
        return recipient;
    }

    public String getSender(){
        return sender;
    }
}
