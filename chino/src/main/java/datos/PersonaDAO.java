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
<<<<<<< HEAD
    private static final String SQL_INSERT = "INSERT INTO persona (apellido, nombre, direccion) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET apellido = ?, nombre = ?, direccion = ? WHERE id_persona = ?";
=======
>>>>>>> 724a550d7677c789c75d2a99d94195c930266440

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
<<<<<<< HEAD
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

    public int insertar(Persona persona){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            preparedStatement = conn.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, persona.getApellido());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getDireccion());
            registros = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
                Conexion.close(preparedStatement);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int actualizar(Persona persona){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        int registros = 0;
        try {
            conn = Conexion.getConnection();
            preparedStatement = conn.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, persona.getApellido());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getDireccion());
            preparedStatement.setInt(4, persona.getIdPersona());
            registros = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        finally {
            try {
=======
            try {
                Conexion.close(resultSet);
>>>>>>> 724a550d7677c789c75d2a99d94195c930266440
                Conexion.close(preparedStatement);
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
<<<<<<< HEAD

        }
        return registros;
=======
        }
        return personas;
>>>>>>> 724a550d7677c789c75d2a99d94195c930266440
    }
}
