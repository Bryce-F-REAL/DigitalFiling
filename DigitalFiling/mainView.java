package DigitalFiling;

import java.util.ArrayList;

public class mainView {

    ArrayList<Cabinet> cabList = new ArrayList<Cabinet>();
    


    private void fillList() {
        
    }









    private void newCabinet(String name, String owner) { 
        Cabinet newC = new Cabinet();
        newC.setName(name);
        newC.setOwner(owner);
        cabList.add(newC);
    }


}
