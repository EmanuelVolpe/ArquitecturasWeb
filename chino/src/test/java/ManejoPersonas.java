import datos.PersonaDAO;
import dominio.Persona;

import java.util.List;

public class ManejoPersonas {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        List<Persona> personas = personaDAO.seleccionar();

        for (Persona persona: personas) {
            System.out.println("Persona : " + persona);
        }
    }
}
