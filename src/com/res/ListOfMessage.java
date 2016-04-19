package com.res;

import java.util.List;

public class ListOfMessage {
    List<String> listOfMessage;

    public void fetchMsgStringBySep(String s, Character c) {
        for(String str:s.split("\\"+c)){
            listOfMessage.add(s);
        }
    }

    public String[] getMessage() {
        return listOfMessage.toArray(new String[listOfMessage.size()]);
    }


}
