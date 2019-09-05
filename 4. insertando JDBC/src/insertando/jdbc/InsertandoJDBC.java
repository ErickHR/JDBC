package insertando.jdbc;

import java.sql.*;

public class InsertandoJDBC {

    
    public static void main(String[] args) {
        
        String SQL_DRIVER = "com.mysql.jdbc.Driver";
        String SQL_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        String SQL_USER = "root";
        String SQL_PASS = "Erickrivas";
        String SQL_INSERT = " INSERT INTO persona(nombre, apellido) VALUES(?, ?) ";
        
        try {
            
            Class.forName(SQL_DRIVER);
            Connection conn = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
            
            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, "Nelida" );
            stmt.setString(2, "Llanahuilca" );
            
            int res = stmt.executeUpdate();
            
            if(res>0) System.out.println("insertado");
            else System.out.println("no fue insertado");
            
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
