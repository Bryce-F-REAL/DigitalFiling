package DigitalFiling;

import java.nio.file.Path;
import java.util.Scanner;

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


    private boolean unlock( String dataPass) { //method to check a password against the stored password for the purpose of unlocking
        Scanner sc = new Scanner(System.in);
    System.out.println("Please enter Password");
    String pass = sc.nextLine();
    if(dataPass.equals(pass)){ 
        return true;
    } else {
        return false;
    }

    }

}
