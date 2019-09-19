/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.bean.Usuario;

/**
 *
 * @author Alumno
 */
public class UsuarioDAO {
    
    public static Usuario validarUsuario(String us, String pass){
        
        Usuario user = null;
        
        String sql = "select * from usuario where usuario = ? and password = ?";
        try {
            Connection conn = Conexion.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, us);
            stmt.setString(2, pass);
            
            ResultSet rs = stmt.executeQuery();
            
            if( rs.next() ){
                user = new Usuario();
                user.setIdusuario(rs.getInt(1));
                user.setUsuario(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setEstado(rs.getString(4));
                user.setCodal(rs.getInt(5));
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return user;
        
    }
    
}
