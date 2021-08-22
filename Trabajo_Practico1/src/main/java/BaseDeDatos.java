import org.apache.derby.jdbc.EmbeddedDriver;

import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDeDatos {

    public static void main(String[] args) {

        String driver = "org.apache.derby.jdbc.EmbeddedDriver";
        String uri = "jdbc:derby:MyDerbyDB;create=true";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }


        try {
            Connection conn = DriverManager.getConnection(uri);
            createTables(conn);
            addPerson(conn,1,"Manu",41);
            addPerson(conn,2,"Ana",40);
            addPerson(conn,3,"Eric",35);
            addPerson(conn,4,"Pali",22);
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void createTables(Connection conn) throws SQLException {
        String table =  "CREATE TABLE persona(" +
                "id INT, " +
                "nombre VARCHAR(500)," +
                "edad INT, " +
                "PRIMARY KEY(id))";
        conn.prepareStatement(table).execute();
        conn.commit();
    }

    private static void addPerson(Connection conn, int id, String nombre, int edad) throws SQLException {
        String insert = "INSERT INTO persona (id, nombre, edad) VALUES(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setInt(1, id);
        ps.setString(2, nombre);
        ps.setInt(3, edad);
        ps.executeUpdate();
        ps.close();
        conn.commit();
    }
}
