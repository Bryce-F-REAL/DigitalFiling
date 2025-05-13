package DigitalFiling;



import java.util.ArrayList;

public class mainView {

    ArrayList<Cabinet> cabList = new ArrayList<Cabinet>(); //make sure to allow for comparison between this and database objects in order to make changes
    
    //limit to ONE cabinet view at a time, as multiple opened at the same time might cause some serious issues (concurrency is a bitch)


    public static void main() {
        mainView m = new mainView();
        m.fillList();
    }
    public void fillList() {
        //gets properties here
        JavaToSQL2 interp = new JavaToSQL2();
        String name = "";
        String owner = "";
        int idMax = 12;
        for (int i = 1; i <= idMax; i++ ) { //maybe instead have it go to the interperator to create hte cabinets and ship them over here?
            String tid = "" + i;
            System.out.println("adding element " + i);
            Cabinet temp = interp.createFromInfo(tid);
            cabList.add(temp); //talk to henry about the possibility of shipping Cabinets directly from the database
        }
        
    }


    private void refreshView() {
        //will go back through the existing list and create GUI elements based off the cabinet objects
    
        
    }







    /* private Cabinet newCabinet(String name, String owner) { 
        Cabinet newC = new Cabinet();
        newC.setName(name);
        newC.setOwner(owner);
        return newC; //fuck man this needs to work
    } */


}
