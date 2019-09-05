package modificando.jdbc;

import java.sql.*;

public class ModificandoJDBC {

    public static void main(String[] args) {
        
        String SQL_DRIVER = "com.mysql.jdbc.Driver";
        String SQL_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        String SQL_USER = "root";
        String SQL_PASS = "Erickrivas";
        String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=? WHERE id_persona=?";
        
        try {
            
            Class.forName(SQL_DRIVER);
            Connection conn = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
            
            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, "Jack");
            stmt.setString(2, "Garcia");
            stmt.setInt(3, 2);
            
            int res = stmt.executeUpdate();
            
            if( res > 0 )System.out.println("modificado");
            else System.out.println("no se modifico");
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
