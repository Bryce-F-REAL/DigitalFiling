package DigitalFiling;

import java.util.ArrayList;

public class mainView {

    ArrayList<Cabinet> cabList = new ArrayList<Cabinet>();
    


    private void fillList() {
        //gets properties here
        String name = "";
        String owner = "";
        int idMax = 64;
        for (int i = 0; i < idMax; i++ ) { //maybe instead have it go to the interperator to create hte cabinets and ship them over here?
            cabList.add(newCabinet(name, owner)); //talk to henry about the possibility of shipping Cabinets directly from the database
        }
        
    }


    private void refreshView() {
        //will go back through the existing list and create GUI elements based off the cabinet objects
        
    }







    private Cabinet newCabinet(String name, String owner) { 
        Cabinet newC = new Cabinet();
        newC.setName(name);
        newC.setOwner(owner);
        return newC;
    }


}
