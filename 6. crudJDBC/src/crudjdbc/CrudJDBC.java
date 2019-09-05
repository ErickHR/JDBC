package crudjdbc;

import java.sql.*;
import java.util.Scanner;

public class CrudJDBC {

    public static void main(String[] args) {
        
        String SQL_DRIVER = "com.mysql.jdbc.Driver";
        String SQL_URL = "jdbc:mysql://localhost:3306/sga?useSSL=false";
        String SQL_USER = "root";
        String SQL_PASS = "Erickrivas";
        
        Scanner teclado = new Scanner(System.in);
        
        String id, nombre, apellido;
        int opcion;
        
        try {
            
            Class.forName(SQL_DRIVER);
            
            Connection conn = DriverManager.getConnection(SQL_URL, SQL_USER, SQL_PASS);
            
            System.out.println("CONEXION ESTABLECIDO");
            
            do{
                
                opciones();
                opcion = teclado.nextInt();
                
                switch(opcion){
                    case 1:
                        mostrar(conn);
                        break;
                    case 2:
                        System.out.print("\nNOMBRE: ");
                        nombre = teclado.next();
                        System.out.print("APELLIDO: ");
                        apellido = teclado.next();
                        insertar(conn, nombre, apellido);
                        mostrar(conn);
                        break;
                    case 3:
                        System.out.print("\nNOMBRE: ");
                        nombre = teclado.next();
                        System.out.print("APELLIDO: ");
                        apellido = teclado.next();
                        System.out.print("ID: ");
                        id = teclado.next();
                        System.out.println("\nREGISTRO ANTIGUO");
                        mostrar(conn);
                        modificar(conn, nombre, apellido, id);
                        System.out.println("\nREGISTRO NUEVO");
                        mostrar(conn);
                        break;
                    case 4:
                        System.out.print("ID: ");
                        id = teclado.next();
                        System.out.println("\nREGISTRO ANTIGUO");
                        mostrar(conn);
                        eliminar(conn, id);
                        System.out.println("\nREGISTRO NUEVO");
                        mostrar(conn);
                        break;
                    case 5:
                        System.out.print("ID: ");
                        id = teclado.next();
                        mostrarNombre(conn, id);
                        break;
                    case 6:
                        System.out.println("CERRANDO CONSOLA...");
                        break;
                    default:
                        System.out.println("\n\nopcion incorrecta");
                        
                }
                
            }while(opcion != 6);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void opciones(){
        System.out.print("\n\n***REGISTRO***"
                + "\n1. MOSTRAR"
                + "\n2. INSERTAR"
                + "\n3. MODIFICAR"
                + "\n4. ELIMINAR"
                + "\n5. BUSCAR POR ID"
                + "\n6. SALIR"
                + "\nOPCION: ");
    }
    
    public static void mostrar(Connection conn){
        
        String SQL_QUERY = "SELECT * FROM persona";
        
        try {
           
            Statement stmt = conn.createStatement();
            
            ResultSet res = stmt.executeQuery(SQL_QUERY);
            
            System.out.println("\nID\tNOMBRE\tAPELLIDO");
            
            while(res.next())
                System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3));
            
            res.close();
            stmt.close();
            
        } catch (Exception e) {
            System.out.println("\n\nERROR AL MOSTRAR");
            e.printStackTrace();
        }
        
    }
    
    public static void insertar(Connection conn, String nombre, String apellido){
        
        String SQL_INSERT = "INSERT INTO persona(nombre, apellido) VALUES (?, ?)";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            
            int res = stmt.executeUpdate();
            
            if (res > 0)
                System.out.println("\n\nINSERTADO");
            else 
                System.out.println("\n\nNO FUE INSERTADO");
            
            stmt.close();
            
        } catch (Exception e) {
            System.out.println("\n\nERROR AL INSERTAR");
            e.printStackTrace();
        }
        
    }
    
    public static void modificar(Connection conn, String nombre, String apellido, String id){
        
        String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ? WHERE id_persona = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setString(3, id);
            
            int res = stmt.executeUpdate();
            
            if(res > 0)
                System.out.println("REGISTRO MODIFICADO");
            else 
                System.out.println("NO FUE MODIFICADO");
            
            stmt.close();
            
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR");
            e.printStackTrace();
        }
        
    }
    
    public static void eliminar(Connection conn, String id){

    String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    try {

        PreparedStatement stmt = conn.prepareStatement(SQL_DELETE);

        stmt.setString(1, id);

        int res = stmt.executeUpdate();

        if(res > 0)
            System.out.println("REGISTRO ELIMINADO");
        else 
            System.out.println("NO FUE ELIMINADO");

        stmt.close();

    } catch (Exception e) {
        System.out.println("ERROR AL ELIMINAR");
        e.printStackTrace();
    }
        
    }

    public static void mostrarNombre(Connection conn, String id){
        
        String SQL_QUERYNAME = "SELECT * FROM persona WHERE nombre = " + "\"" + id + "\"";
        System.out.println(SQL_QUERYNAME);
        try {
            
            Statement stmt = conn.createStatement();
            
            ResultSet res = stmt.executeQuery(SQL_QUERYNAME);
            
            System.out.println("\nID\tNOMBRE\tAPELLIDO");
            
            while(res.next())
                System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3));
            
            res.close();
            stmt.close();
            
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR");
            e.printStackTrace();
        }
        
    }
    
}
