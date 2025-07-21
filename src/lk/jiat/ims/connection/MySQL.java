/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lk.jiat.ims.connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {
    
    private static final String DATABSE = "inventory_management";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Ayomalkaus#2k23";
    private static Connection connection;
    
    public static Connection getConnection(){
        
        if(connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + DATABSE,
                        USERNAME,
                        PASSWORD);
            } catch (ClassNotFoundException|SQLException e) {
                e.printStackTrace();
            }
        }
        
        return connection;
    }
    
    public static ResultSet execute(String query) throws SQLException {

        Statement smt = getConnection().createStatement();
        if (query.toUpperCase().startsWith("SELECT")) {
            return smt.executeQuery(query);
        } else {
            smt.executeUpdate(query);
            return null;
        }

    }
    
}
