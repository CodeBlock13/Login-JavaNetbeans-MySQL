/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import com.mycompany.login.FormMenuPrincipal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author NoName
 */
public class CLogin {
    
    public void validUser(JTextField usuario, JPasswordField contraseña){
        
         try {
             ResultSet rs = null;
             PreparedStatement ps = null;
             
             Clases.CConexion objConn = new Clases.CConexion();
             
             String query = "select * from Usuarios where Usuarios.ingresoUsuario = (?) and Usuarios.ingresoContraseña = (?)";
             ps = objConn.stablishConnection().prepareStatement(query);
             
             String strPassField = String.valueOf(contraseña.getPassword());
             
             ps.setString(1, usuario.getText());
             ps.setString(2, strPassField);
             
             rs = ps.executeQuery();
             
             if(rs.next()){
                 JOptionPane.showMessageDialog(null, "Acceso Autorizado");
                 FormMenuPrincipal objMenuPrincipal = new FormMenuPrincipal();
                 objMenuPrincipal.setVisible(true);
                 
             }else{
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
             }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: "+e.toString());
        }
    }
}
