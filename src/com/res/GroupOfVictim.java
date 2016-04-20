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

    public String[] getRecipient(){
        return recipient.toArray(new String[recipient.size()]);
    }

    public String getSender(){
        return sender;
    }
}
