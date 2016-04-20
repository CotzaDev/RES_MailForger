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
 * Class who manage a list of victim
 */
public class ListOfVicitim {
    List<String> lstAdrVictim;

    ListOfVicitim() {
        lstAdrVictim = new ArrayList<String>();
    }

    ListOfVicitim(List<String> lst) {
        this.lstAdrVictim = lst;
    }

    public void loadJson(String filename){
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(filename));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray person = (JSONArray) jsonObject.get("person");
            Iterator<JSONObject> iterator = person.iterator();
            while (iterator.hasNext()) {
                this.addVictim((String) (iterator.next().get("mail")));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public int getNbrVictim() {
        return lstAdrVictim.size();
    }

    public List<String> getASublist(int i, int i1) {
        return lstAdrVictim.subList(i, i1);
    }

    public String getOneVictim(int i) {
        return lstAdrVictim.get(i);
    }

    public void addVictim(String next) {
        lstAdrVictim.add(next);
    }
}
