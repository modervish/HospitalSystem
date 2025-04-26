
package com.mycompany.hospital.db.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Dao {
    public static Connection getConnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost/hospital_system","root","");
        if (con!=null) {
            
            return con;
        }
        return null;
    }
        public void closeConnection(Connection con)throws Exception{
            if (con!=null) {
                con.close();
            }
        
        }
}