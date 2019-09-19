package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class Conexion {
    
    private static String url = "jdbc:mysql://localhost:3306/bd?useSSL=false";
    private static String user = "root";
    private static String pass = "12345678";
    private static String Driver = "com.mysql.jdbc.Driver";
    private static  Connection conn = null;
    
    public static Connection abrir(){
        
        try {
            Class.forName(Driver);
            
           conn =  DriverManager.getConnection(url, user, pass);
            
            return conn;
            
        } catch (Exception e) {
            System.out.println("Error de la conexion");
            return null;
        }
        
    }
    
}
