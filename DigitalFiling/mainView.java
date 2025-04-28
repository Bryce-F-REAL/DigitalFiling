package DigitalFiling;

import java.util.ArrayList;

public class mainView {

    ArrayList<Cabinet> cabList = new ArrayList<Cabinet>();
    


    private void fillList() {
        //gets properties here
        String name;
        String owner;
        newCabinet(name, owner);
    }









    private void newCabinet(String name, String owner) { 
        Cabinet newC = new Cabinet();
        newC.setName(name);
        newC.setOwner(owner);
        cabList.add(newC);
    }


}
