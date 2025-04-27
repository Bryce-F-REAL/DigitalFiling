package DigitalFiling;

import java.nio.file.Path;

public class Cabinet {
    private int ID;
    private String Name;
    private String Owner;
    private Path cabPath; 

    private void setPath(Path p) {
        // method to initialize the path of a cabinet
        this.cabPath = p;
    }

    private void setOwner(String own) {
        //method to set owner property
        this.Owner = own;
    }

    private void setName(String na) {
        //method to set the name property
        this.Name = na;
    }

}
