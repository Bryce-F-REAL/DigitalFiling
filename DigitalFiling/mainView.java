package DigitalFiling;

import java.util.ArrayList;

public class mainView {

    ArrayList<Cabinet> cabList = new ArrayList<Cabinet>();
    


    private void fillList() {
        //gets properties here
        String name = "";
        String owner = "";
        int idMax = 64;
        for (int i = 0; i < idMax; i++ ) {
            cabList.add(newCabinet(name, owner));
        }
        
    }









    private Cabinet newCabinet(String name, String owner) { 
        Cabinet newC = new Cabinet();
        newC.setName(name);
        newC.setOwner(owner);
        return newC;
    }


}
