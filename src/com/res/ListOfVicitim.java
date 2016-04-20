package com.res;

import java.util.ArrayList;
import java.util.List;

/**
 * Class who manage a list of victim
 */
public class ListOfVicitim {
    List<String> lstAdrVictim = new ArrayList<String>();

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
