package introduccion.jdbc;
import java.sql.*;

public class IntroduccionJDBC {

    public static void main(String[] args) {
        // TODO code application logic here
        String SQL_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        String SQL_DRIVER = "com.mysql.jdbc.Driver";
        String SQL_USER = "root";
        String SQL_PASS = "Erickrivas";
        String SQL_SELECT = "SELECT * FROM persona";
        
        try {
            
            Class.forName(SQL_DRIVER);
            Connection conexion = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
            Statement instruccion = conexion.createStatement();
            
            ResultSet result = instruccion.executeQuery(SQL_SELECT);
            
            System.out.println("ID\tNOMBRE\t\tAPELLIDO\n----------------------------------------");
            while(result.next())
                System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t\t" + result.getString(3));
            
            result.close();
            instruccion.close();
            conexion.close();
            
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
