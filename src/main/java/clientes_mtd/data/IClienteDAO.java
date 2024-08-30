package clientes_mtd.data;

import clientes_mtd.domain.Client;

import java.util.List;

public interface IClienteDAO {

    //----------------------------------------->
    //-- We defined the methods to implement -->

    List<Client> listClients();
    boolean searchClientById(Client client);
    boolean searchClientByName(Client client);
    boolean addClient(Client client);
    boolean modifyClient(Client client);
    boolean deleteClient(Client client);

}
