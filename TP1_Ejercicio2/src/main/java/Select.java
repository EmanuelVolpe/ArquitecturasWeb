import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Select {
    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String uri = "jdbc:mysql://localhost:3306/exampledb";

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
            Connection conn = DriverManager.getConnection(uri, "root", "");
            String select = "SELECT * FROM persona";
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
