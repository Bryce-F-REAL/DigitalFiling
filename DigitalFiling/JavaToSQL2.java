/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DigitalFiling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Henry Mutschler
 */
public class JavaToSQL2 {

    String jdbcUrl = "jdbc:mysql://localhost:3306/cabinetdb";
    String username = "root";
    String password = "B00t!";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        String jdbcUrl = "jdbc:mysql://localhost:3306/cabinetdb";
        String username = "root";
        String password = "B00t!";
       
        JavaToSQL2 temp = new JavaToSQL2();
        temp.showCabinetInfo(jdbcUrl, username, password, "4");
        temp.showCabinetInfo(jdbcUrl, username, password, "2");
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            // Now you can use 'connection' to execute SQL queries.
            // Don't forget to close the connection when you're done.
            //  String updateQuery = "INSERT INTO cabinet (CabinetID, CabinetName, DateOfCreation, CabinetLocked, Password, Owner, Filepath) VALUES(12, 'My dudes', '2025-12-21', 1, 'myNUTT!', 'Bosh', '/cabinets/Homework');";

//            String createTable = "CREATE TABLE cabinet ("
//                    + "CabinetID int (100) Primary key, "
//                    + "CabinetName VARCHAR(20), "
//                    + "DateOfCreation date, "
//                    + "CabinetLocked boolean, "
//                    + "Password Varchar(20), "
//                    + "Owner Varchar(20), "
//                    + "FilePath LONGTEXT)"; //untested
//            String createSchema = "CREATE SCHEMA myNewSchema"; //untested
//            String createDataBase = "CREATE DATABASE myDatabase"; //untested

            //  PreparedStatement preparedStatement2 = connection.prepareStatement(updateQuery);
            //  preparedStatement2.executeUpdate();
            //update to change, query to look
            // executeUpdate and executeQuery
            // ResultSet makes it so we can place the data elsewhere like a string
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
       
    }

    public void showCabinetName(String jdbcUrl, String username, String password, String cabinetName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet WHERE cabinet.CabinetName =" + cabinetName + ";";
            // Is this whatcha wanted? eyyyyyup
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetName = executeQuery.getString("CabinetName");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param jdbcUrl
     * @param username
     * @param password
     * @param cabinetName
     * @return
     */
    public void showCabinetInfo(String jdbcUrl, String username, String password, String cabinetID) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet WHERE cabinet.CabinetID =" + cabinetID + ";";
            // Is this whatcha wanted? eyyyyyup
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetID = executeQuery.getString("CabinetID"); //add strings for all info
                String CabinetName = executeQuery.getString("CabinetName");
                String CabinetDate = executeQuery.getString("DateOfCreation");
                String CabinetLock = executeQuery.getString("CabinetLocked");
                String CabinetPassword = executeQuery.getString("Password");
                String CabinetOwner = executeQuery.getString("Owner");
                String CabinetPath = executeQuery.getString("FilePath");
                // print the results
                System.out.format("%s, %s, \n", CabinetID, CabinetName); //make sure it prints all info
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Cabinet createFromInfo(String cabinetID) {
        Cabinet ret = new Cabinet(Integer.parseInt(cabinetID));
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet WHERE cabinet.CabinetID =" + cabinetID + ";";
            // Is this whatcha wanted? eyyyyyup
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetID = executeQuery.getString("CabinetID"); //add strings for all info
                String CabinetName = executeQuery.getString("CabinetName");
                String CabinetDate = executeQuery.getString("DateOfCreation");
                String CabinetLock = executeQuery.getString("CabinetLocked");
                String CabinetPassword = executeQuery.getString("Password");
                String CabinetOwner = executeQuery.getString("Owner");
                String CabinetPath = executeQuery.getString("FilePath");
                // print the results
                System.out.format("%s, %s, \n", CabinetID, CabinetName); //make sure it prints all info
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    public void changeCabinetName(String cabinetID,String newName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet WHERE cabinet.CabinetID =" + cabinetID + ";";
            String changeName = "UPDATE cabinet SET cabinet.CabinetName = '" + newName + "' WHERE cabinet.CabinetID =" + cabinetID + ";";
            // Is this whatcha wanted? eyyyyyup
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            PreparedStatement preparedStatement2 = connection.prepareStatement(changeName);
            ResultSet executeQuery = preparedStatement1.executeQuery();
            preparedStatement2.executeUpdate();
            
            while (executeQuery.next()) //How we get the results
            {
                String CabinetID = executeQuery.getString("CabinetID"); //add strings for all info
                String CabinetName = executeQuery.getString("CabinetName");
                String CabinetDate = executeQuery.getString("DateOfCreation");
                String CabinetLock = executeQuery.getString("CabinetLocked");
                String CabinetPassword = executeQuery.getString("Password");
                String CabinetOwner = executeQuery.getString("Owner");
                String CabinetPath = executeQuery.getString("FilePath");
                // print the results
                System.out.format("%s, %s, \n", CabinetID, CabinetName); //make sure it prints all info
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    


    public void showCabinetDate(String jdbcUrl, String username, String password, String cabinetName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet cabinet.CabinetName =" + cabinetName + ";";
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetName = executeQuery.getString("DateOfCreation");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showCabinetLockStat(String jdbcUrl, String username, String password, String cabinetName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet cabinet.CabinetName =" + cabinetName + ";";
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetName = executeQuery.getString("CabinetLocked");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showCabinetPassword(String jdbcUrl, String username, String password, String cabinetName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet cabinet.CabinetName =" + cabinetName + ";";
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results //might not be needed for one result?
            {
                String CabinetName = executeQuery.getString("Password");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showCabinetOwner(String jdbcUrl, String username, String password, String cabinetName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet cabinet.CabinetName =" + cabinetName + ";";
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetName = executeQuery.getString("Owner");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showCabinetFilePath(String jdbcUrl, String username, String password) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet;";
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetName = executeQuery.getString("FilePath");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showCabinetID(String jdbcUrl, String username, String password, String cabinetName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet cabinet.CabinetName =" + cabinetName + ";";
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetName = executeQuery.getString("CabinetID");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllCabinetIDs(String jdbcUrl, String username, String password) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet;";
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetName = executeQuery.getString("CabinetID");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void showAllCabinetNames(String jdbcUrl, String username, String password) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet;";
            PreparedStatement preparedStatement1 = connection.prepareStatement(allQuery);
            ResultSet executeQuery = preparedStatement1.executeQuery();

            while (executeQuery.next()) //How we get the results
            {
                String CabinetName = executeQuery.getString("CabinetName");
                // print the results
                System.out.format("%s, \n", CabinetName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//turn things into return comands
}
