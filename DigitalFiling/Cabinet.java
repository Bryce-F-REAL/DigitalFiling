package DigitalFiling;

import java.nio.file.Path;
import java.util.Scanner;

public class Cabinet  {
    private int ID;
    private String Name;
    private String Owner;
    private Path cabPath; 
    private String password;
    private boolean lockState;
    private String DoC;


        public Cabinet (int i) {
            this.ID = i;
        }

    public void setAll(String na,  String own, String date, String lock, String pass, Path p  ) { //exists for the purpose of making life easier
        this.Name = na;
        this.Owner = own;
        this.cabPath = p;
        this.password = pass;
        this.DoC = date;
        int temp = Integer.parseInt(lock);
        if (temp == 0) {
            this . lockState = false;
        } else if (temp == 0) {
            this.lockState = true;
        }
    }


    public void setPath(Path p) {
        // method to initialize the path of a cabinet
        this.cabPath = p;
    }

    public void setOwner(String own) {
        //method to set owner property
        this.Owner = own;
    }

    public void setName(String na) {
        //method to set the name property
        this.Name = na;
    }

    public void setPass(String pass) {
        this.password = pass;
    }



    public boolean unlock( String dataPass) { //method to check a password against the stored password for the purpose of unlocking
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
