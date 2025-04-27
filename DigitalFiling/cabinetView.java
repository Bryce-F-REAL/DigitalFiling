package DigitalFiling;

import java.io.File;
import java.util.ArrayList;

public class cabinetView {
     ArrayList<Cabinet> cabList = new ArrayList<Cabinet>();
     ArrayList<File> cabFiles = new ArrayList<File>();
     Filepath location;

    public void newCabinet(String name) { 
        Cabinet newC = new Cabinet();
        newC.setName(name);
        cabList.add(newC);
    }

    public void initializeCabinet() {
        //essentially this method collects the files to display for this method
    }


}
