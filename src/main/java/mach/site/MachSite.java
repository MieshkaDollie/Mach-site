/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mach.site;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Mieshke
 */
public class MachSite {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        Database db = new Database();
        db.connect();
        
//        db.createUsersTable();
//        db.createEmpTable();
    }
    
}
