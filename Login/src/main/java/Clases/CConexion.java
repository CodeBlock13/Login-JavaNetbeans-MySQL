/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author NoName
 */
public class CConexion {
    Connection connect;
    
    String user = "root";
    String passwd = "$Angelofdeath66";
    String bd = "login";
    String ip = "127.0.0.1";
    String port = "3306";
    
    String chain = "jdbc:mysql://"+ip+":"+port+"/"+bd;
    
    public Connection stablishConnection(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(chain, user, passwd);
            //JOptionPane.showMessageDialog(null, "Se ha establecido la conexion");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido conectar " + e.toString());
            
        }
        
        return connect; 
}
    
    
    
}
