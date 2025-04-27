package DigitalFiling;

public class cabinetView {
     Cabinet[] cabList = new Cabinet[64];

    public void newCabinet(String name) { 
        Cabinet newC = new Cabinet();
        newC.setName(name);
    }


}
