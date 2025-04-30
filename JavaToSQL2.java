/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javatosql2;

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

    /**
     * @param args the command line arguments
     */
 public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        
        String jdbcUrl = "jdbc:mysql://localhost:3306/cabinetdb";
        String username = "root";
        String password = "B00t!";

        try {
          
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            // Now you can use 'connection' to execute SQL queries.
            // Don't forget to close the connection when you're done.
          //  String updateQuery = "INSERT INTO cabinet (CabinetID, CabinetName, DateOfCreation, CabinetLocked, Password, Owner, Filepath) VALUES(12, 'My dudes', '2025-12-21', 1, 'myNUTT!', 'Bosh', '/cabinets/Homework');";

            String createTable = "CREATE TABLE cabinet ("
                    + "CabinetID int (100) Primary key, "
                    + "CabinetName VARCHAR(20), "
                    + "DateOfCreation date, "
                    + "CabinetLocked boolean, "
                    + "Password Varchar(20), "
                    + "Owner Varchar(20), "
                    + "FilePath LONGTEXT)"; //untested
            String createSchema = "CREATE SCHEMA myNewSchema"; //untested
            String createDataBase = "CREATE DATABASE myDatabase"; //untested
           
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
       public static void showCabinetName(String jdbcUrl, String username, String password, String cabinetName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet cabinet.CabinetName =" + cabinetName +";";
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
    public static void returnCabinetName(String jdbcUrl, String username, String password, String cabinetName) {
        try {

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String allQuery = "SELECT * FROM cabinet cabinet.CabinetName =" + cabinetName +";";
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
      
}
