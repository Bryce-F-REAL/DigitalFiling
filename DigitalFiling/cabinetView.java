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
        //essentially this method collects the files to display for this method

    };
    File<> listOfFiles = location.listFiles();

    for (File file : listOfFiles) {
    if (file.isFile()) {
        System.out.println(file.getName());
    }
}


}
