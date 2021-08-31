import datos.PersonaDAO;
import dominio.Persona;

import java.util.List;

public class ManejoPersonas {
    public static void main(String[] args) {

        PersonaDAO personaDAO = new PersonaDAO();

        //INSERTANDO UN NUEVO OBJETO DE TIPO PERSONA EN LA DDBB
        //Persona personaNueva = new Persona("Eric", "Unzue", "Roca 600");
        //personaDAO.insertar(personaNueva);

        //ACTUALIZO UNA PERSONA EXISTENTE
        Persona personaNueva = new Persona(3, "Mica", "Yaquinta", "Castelli 1000");
        personaDAO.actualizar(personaNueva);

        List<Persona> personas = personaDAO.seleccionar();

        for (Persona persona: personas) {
            System.out.println("Persona : " + persona);
        }
    }
}
