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
import javax.xml.transform.Result;
import modelo.bean.Alumno;

/**
 *
 * @author Alumno
 */
public class AlumnoDAO {
    
    private static Alumno al;
    private static String sql = "select * from alumno where codal=?";
    
    public static Alumno buscarID(int cod){
        try{
            Connection conn = Conexion.abrir();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, cod);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                al = new Alumno();
                al.setCodad(rs.getInt(1));
                al.setNombre(rs.getString(2));
                al.setApaterno(rs.getString(3));
                al.setAmaterno(rs.getString(4));
                al.setDireccion(rs.getString(5));
                al.setFoto(rs.getString(6));
            }
            
            rs.close();
            stmt.close();
            conn.close();
            
            return al;
            
        }catch(Exception e){
            System.out.println("Error de alumno DAO");
            return null;
        }
    
    }
}
