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
        return false;
    }

    @Override
    public boolean searchClientByName(Client client) {
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

        var lista = clientes.listClients();

        lista.forEach(System.out::println);

    }
}
