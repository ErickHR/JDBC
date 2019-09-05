package eliminar.jdbc;

import java.sql.*;

public class EliminarJDBC {

    public static void main(String[] args) {
        
        String SQL_DRIVER = "com.mysql.jdbc.Driver";
        String SQL_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        String SQL_USER = "root";
        String SQL_PASS = "Erickrivas";
        String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
        
        try {
            
            Class.forName(SQL_DRIVER);
            Connection conn = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
            
            PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, "6");
            
            int res = stmt.executeUpdate();
            
            if(res > 0)System.out.println("eliminado");
            else System.out.println("no existe");
            
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
