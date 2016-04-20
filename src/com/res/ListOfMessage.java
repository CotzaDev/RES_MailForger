package com.res;

import java.util.ArrayList;
import java.util.List;


/**
 * Class to manage a list of message
 */
public class ListOfMessage {
    List<Message> listOfMessage = new ArrayList<Message>();

    public List<Message> getMessage() {
        return listOfMessage;
    }

    public void addMessage(Message next) {
        listOfMessage.add(next);
    }
}
