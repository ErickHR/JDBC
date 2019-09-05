package buscar.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BuscarJDBC {

    public static void main(String[] args) {
        
        String SQL_DRIVER = "com.mysql.jdbc.Driver";
        String SQL_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        String SQL_USER = "root";
        String SQL_PASS = "Erickrivas";
        String SQL_QUERY = "SELECT * FROM persona WHERE id_persona=?";
        
        try {
            
            Class.forName(SQL_DRIVER);
            Connection conn = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
            
            PreparedStatement stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, "3");
            
            ResultSet res = stmt.executeQuery();
            
            if( res.next() ) System.out.println("Nombre: " + res.getString(2) + "\nApellido: " + res.getString(3));
            else System.out.println("no existe");
            
            
            res.close();
            stmt.close();
            conn.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
