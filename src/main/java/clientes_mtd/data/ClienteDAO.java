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
        return false;
    }

    @Override
    public boolean modifyClient(Client client) {
        return false;
    }

    @Override
    public boolean deleteClient(Client client) {
        return false;
    }

    public static void main(String[] args) {

        IClienteDAO clientes = new ClienteDAO();

//        var lista = clientes.listClients();
//
//        lista.forEach(System.out::println);

        var cliente2 = new Client("Jose");

        var encontrado = clientes.searchClientByName(cliente2);

        System.out.println("Cliente encontrado: " + cliente2);



    }
}
