package clientes_mtd.data;
import clientes_mtd.connection.Conexion;
import clientes_mtd.domain.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{


    //---------------------------------------------->
    //--List clientes ------------------------------>


    @Override
    public List<Client> listClients() {

        //-- We defined clients list

        List<Client> clients = new ArrayList<>();

        //-- We prepare the sentence prepare Statement, result set y connection

        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConnection();

        //-- We created the sql sentence

        String sql = "SELECT * FROM cliente ORDER BY idcliente";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){

                Client client = new Client();

                client.setIdcliente(rs.getInt("idcliente"));
                client.setNombre(rs.getString("nombre"));
                client.setApellido(rs.getString("apellido"));
                client.setCiudad(rs.getString("ciudad"));
                client.setDireccion(rs.getString("direccion"));
                client.setTelefono(rs.getString("telefono"));
                client.setPuntosPC(rs.getInt("puntosPC"));

                clients.add(client);

            }

        }catch (Exception e){
            System.out.println("Error to list clients: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error to close connection: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }

        return clients;

    }


    //---------------------------------------------------->
    //--Search client by ID ------------------------------>


    @Override
    public boolean searchClientById(Client client) {

        //We prepared sentences for connection sql
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConnection();
        String sql = "SELECT * FROM cliente WHERE idcliente = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1,client.getIdcliente());

            rs = ps.executeQuery();

            if(rs.next()){

                client.setNombre(rs.getString("nombre"));
                client.setApellido(rs.getString("apellido"));
                client.setCiudad(rs.getString("ciudad"));
                client.setDireccion(rs.getString("direccion"));
                client.setTelefono(rs.getString("telefono"));
                client.setPuntosPC(rs.getInt("puntosPC"));
                return true;
            }

        }catch (Exception e){
            System.out.println("Error to find client for id: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error to close connection: "+e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean searchClientByName(Client client) {

        //We prepared statement for sentences sql

        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConnection();
        String sql = "SELECT * FROM cliente WHERE nombre = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1,client.getNombre());

            rs = ps.executeQuery();

            if(rs.next()){

                client.setIdcliente(rs.getInt("idcliente"));
                client.setApellido(rs.getString("apellido"));
                client.setCiudad(rs.getString("ciudad"));
                client.setDireccion(rs.getString("direccion"));
                client.setTelefono(rs.getString("telefono"));
                client.setPuntosPC(rs.getInt("puntosPC"));

                return true;
            }

        }catch (Exception e){
            System.out.println("Error to find client: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error to close connection: "+e.getMessage());
            }

        }

        return false;
    }

    @Override
    public boolean addClient(Client client) {

        //We prepared statement for sentences sql

        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        String sql = "INSERT INTO cliente(nombre,apellido,ciudad,direccion,telefono,puntosPC)"
                + "VALUES(?,?,?,?,?,?)";

        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, client.getNombre());
            ps.setString(2, client.getApellido());
            ps.setString(3, client.getCiudad());
            ps.setString(4, client.getDireccion());
            ps.setString(5, client.getTelefono());
            ps.setInt(6, client.getPuntosPC());
            ps.execute();
            return true;

        }catch (Exception e){
            System.out.println("Error to add client: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error to close connection: "+e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean modifyClient(Client client) {

        //We prepared statement for sentences sql

        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        String sql = "UPDATE cliente SET nombre =?, apellido=?, ciudad=?, direccion=?, telefono=?, puntosPC=? "
                +"WHERE idcliente = ?";

        try {

            ps = con.prepareStatement(sql);

            ps.setString(1,client.getNombre());
            ps.setString(2,client.getApellido());
            ps.setString(3,client.getCiudad());
            ps.setString(4,client.getDireccion());
            ps.setString(5,client.getTelefono());
            ps.setInt(6,client.getPuntosPC());
            ps.setInt(7,client.getIdcliente());

            ps.execute();
            return true;

        }catch (Exception e){
            System.out.println("Error to update client: "+e.getMessage());
        }finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error to close connection: "+e.getMessage());
            }
        }

        return false;
    }

    @Override
    public boolean deleteClient(Client client) {

        //We prepared statement for sentences sql

        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        String sql = "DELETE FROM cliente WHERE idcliente = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1,client.getIdcliente());
            ps.execute();
            return true;

        }catch (Exception e){
            System.out.println("Error to delete client: "+e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error to close connection:"+e.getMessage());
            }
        }

        return false;
    }
}
