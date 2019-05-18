package mach.site;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    Connection con;
    Statement stmt;
    
    
   public String getProgramPath() throws IOException{
        
        String currentDir = System.getProperty("user.dir");
        
        currentDir = currentDir.replace("\\", "/");
        
        return currentDir;
        
    }
    
    public void connect() throws IOException{
       
        //file name specifying the locaion of the database file
        String filename = getProgramPath() + "/MachSite.accdb";
        
        //url to the database to make the java connection
        String dbURL = "jdbc:ucanaccess://" + filename.trim() + ";DriverID=22;READONLY=true}";

        //the driver name
        String driverName = "net.ucanaccess.jdbc.UcanaccessDriver";
       
         try {
            
            System.out.println("About to Load the JDBC Driver....");
            
            Class.forName(driverName);
            
            System.out.println("Driver Loaded Successfully....");
            System.out.println("About to get a connection....");
            
            con = DriverManager.getConnection(dbURL, "",""); 
            
            System.out.println("Connection Established Successfully....");
            
            stmt = con.createStatement();
           
            
        }
        catch(Exception err){
              
              System.out.println("ERROR: " + err);
              
        }
        
        
    }
    
    public void disconnect() throws SQLException{
       
        con.close(); // close the Connection to let the database know we're done with it
        System.out.println("Closed successfully....");
        
    }
    
    public void createUsersTable() throws SQLException{
        
        String createUsers = "CREATE TABLE User (ID INTEGER PRIMARY KEY, Name VARCHAR(100), Password VARCHAR(100))";
        
        stmt.execute(createUsers);
        
    }
    
    public void createEmpTable() throws SQLException{
        
        String createEmp = "CREATE TABLE Employee (ID INTEGER PRIMARY KEY, Name VARCHAR(100), Surname VARCHAR(100), DOB VARCHAR(100), Address VARCHAR(100), CellNumber VARCHAR(14), Email VARCHAR(100))";
        
        stmt.execute(createEmp);
        
    }
   
}
