package DigitalFiling;

import java.io.File;
import java.util.ArrayList;

public class cabinetView {
    private Cabinet cab;

    public cabinetView (Cabinet View) {
        this.cab = View;
    }


     ArrayList<File> cabFiles = new ArrayList<File>();
     File location = new File(cab.getPath());

    

    public void initializeCabinet() {
        //essentially this method collects the files to display for this method essentailly adds all listed files in a folder to an array list and prints names in console
        File[] listOfFiles = location.listFiles();

        for (File file : listOfFiles) { // taken and modified from stack overflow
        if (file.isFile()) {
        System.out.println(file.getName());
        cabFiles.add(file);
    }

    };
    
}


}
