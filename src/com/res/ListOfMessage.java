package com.res;

import java.util.ArrayList;
import java.util.List;


/**
 * Class to manage a list of message
 */
public class ListOfMessage {
    List<String> listOfMessage = new ArrayList<String>();

    public List<String> getMessage() {
        return listOfMessage;
    }

    public void addMessage(String next) {
        listOfMessage.add(next);
    }
}
