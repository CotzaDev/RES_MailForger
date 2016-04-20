package com.res;

import java.util.List;

public class ListOfVicitim {
    List<String> lstAdrVictim;

    public void fetchAdrStringBySep(String s, Character separator){
        for(String str : s.split("\\"+separator)){
            lstAdrVictim.add(str);
        }
    }

    public int getNbrVictim() {
        return lstAdrVictim.size();
    }

    public List<String> getASublist(int i, int i1) {
        return lstAdrVictim.subList(i,i1);
    }

    public String getOneVictim(int i) {
        return lstAdrVictim.get(i);
    }

    public void addVictim(String next) {
        lstAdrVictim.add(next);
    }
}
