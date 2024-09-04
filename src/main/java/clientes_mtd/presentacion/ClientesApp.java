package clientes_mtd.presentacion;

import clientes_mtd.data.ClienteDAO;
import clientes_mtd.data.IClienteDAO;
import clientes_mtd.domain.Client;
import java.util.List;
import java.util.Scanner;

public class ClientesApp {

    //We defined method main

    public static void main(String[] args) {
        System.out.println("Welcome to application - clientes -");

        menu();

        runApp();




    }




    //---------------------------->
    //---------------------------->
    //---------------------------->

    //Static methods for application

    private static void menu(){
        //Construction of menu
        System.out.println("Choose the number of option in the menu below");
        System.out.println("1. List of clients \n"+
                "2. Search client for id \n"+
                "3. Search client for name \n"+
                "4. Add client \n"+
                "5. Modify client \n"+
                "6. Delete client \n"+
                "7. Exit");
    }

    private static void runApp(){
        //Construction switch
        IClienteDAO client = new ClienteDAO();
        Scanner input = new Scanner(System.in);
        int chosenOption = Integer.parseInt(input.nextLine());
        switch (chosenOption){
            case 1:
                System.out.println("\n--List of clients--\n");
                List<Client> clients = client.listClients();
                clients.forEach(System.out::println);
                System.out.println("\n----------------------\n");
                menu();
                runApp();
                break;

            case 2:
                System.out.println("\nWrite id of the client to search");
                int id = Integer.parseInt(input.nextLine());
                Client clientOptionTwo = new Client(id);
                client.searchClientById(clientOptionTwo);
                System.out.println("\nDates of the client find \n"
                +clientOptionTwo+"\n-----------------------------\n");
                menu();
                runApp();
                break;

            case 7:
                System.out.println("Thank you for used our application");
                break;
        }

    }
}
