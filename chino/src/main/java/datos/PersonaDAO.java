package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.*;


public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, direccion FROM persona";

    public List<Persona> seleccionar(){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<Persona>();

        try {
            conn = Conexion.getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idPersona = resultSet.getInt(1);
                String apellido = resultSet.getString(2);
                String nombre = resultSet.getString(3);
                String direccion = resultSet.getString(4);
                persona = new Persona(idPersona, apellido, nombre, direccion);
                personas.add(persona);
                //System.out.println(idPersona + ", " + apellido + ", " + nombre + ", " + direccion);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(resultSet);
                Conexion.close(preparedStatement);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return personas;
    }
}
