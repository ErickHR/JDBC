package manejopersona;
import datos.PersonasJDBC;
import domain.Persona;
import java.util.List;

public class ManejoPersona {

    public static void main(String[] args) {
        
        PersonasJDBC personasJDBC = new PersonasJDBC();
        personasJDBC.insert("Alberto", "Juarez");
        
    }
    
}
