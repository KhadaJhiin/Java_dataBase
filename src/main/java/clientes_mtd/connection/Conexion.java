package clientes_mtd.connection;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    //----------------------------------------->
    //-- We defined a method type Connection -->

    public static Connection getConnection(){

        Connection conexion = null;
        String dataBase = "mtodo_db";
        String url = "jdbc:mysql://localhost:3306/" + dataBase;
        String user = "root";
        String password = "admin";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            System.out.println("Error to connect to db: " + e.getMessage());
        }

        return conexion;

    }
}
