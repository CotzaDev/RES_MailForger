package com.res;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Class to manage a list of message
 */
public class ListOfMessage {
    List<Message> listOfMessage;

    ListOfMessage() {
        this.listOfMessage = new ArrayList<Message>();
    }

    ListOfMessage(List<Message> lst) {
        this.listOfMessage = lst;
    }

    public void loadJson(String filename){
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filename));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<JSONObject> iterator = msg.iterator();
            while (iterator.hasNext()) {
                JSONObject objm = iterator.next();
                Message m = new Message();
                m.setTitle((String)objm.get("title"));
                m.setSubj((String)objm.get("subject"));
                m.setMsg((String)objm.get("message"));
                this.addMessage(m);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Message> getMessage() {
        return listOfMessage;
    }

    public void addMessage(Message next) {
        listOfMessage.add(next);
    }
}
