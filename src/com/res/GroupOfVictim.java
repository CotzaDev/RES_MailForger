package com.res;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage the group of victim
 */
public class GroupOfVictim {
    private List<String> recipient;
    private String sender;

    GroupOfVictim() {
        this.recipient = new ArrayList<String>();
    }

    GroupOfVictim(List<String> lst, String sender) {
        this.recipient = lst;
        this.sender = sender;
    }

    public void setRecipient(List<String> aSublist) {
        recipient = aSublist;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<String> getRecipient() {
        return recipient;
    }

    public String getSender() {
        return sender;
    }
}
