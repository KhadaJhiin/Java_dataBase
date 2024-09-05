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

            case 3:
                System.out.println("\nWrite name of the client to search");
                String nombreCliente= input.nextLine();
                Client clientOptionThre = new Client(nombreCliente);
                client.searchClientByName(clientOptionThre);
                System.out.println("\nDates of the client find \n"
                        +clientOptionThre+"\n-----------------------------\n");
                menu();
                runApp();
                break;

            case 4:

                System.out.println("\n--Insert dates of client--\n");

                System.out.print("Name: ");
                String name = input.nextLine();

                System.out.print("\nLast name: ");
                String lastName = input.nextLine();

                System.out.print("\nCity: ");
                String city = input.nextLine();

                System.out.print("\nAddress: ");
                String address = input.nextLine();

                System.out.print("\nPhone");
                String phone = input.nextLine();

                System.out.print("\nPoints:");
                int points = Integer.parseInt(input.nextLine());

                Client clientOptionFour = new Client(name,lastName,city,address,phone,points);

                client.addClient(clientOptionFour);

                System.out.println("\nThe client was added successfully\n");

                menu();
                runApp();
                break;

            case 5:

                System.out.println("Insert id of client to modify: ");
                int idUser = Integer.parseInt(input.nextLine());
                Client clExist = new Client(idUser);
                boolean exist = client.searchClientById(clExist);

                if(exist){
                    System.out.println("\n--Insert dates of client to modify--\n");

                    System.out.print("Name: ");
                    String nameFive = input.nextLine();

                    System.out.print("\nLast name: ");
                    String lastNameFive = input.nextLine();

                    System.out.print("\nCity: ");
                    String cityFive = input.nextLine();

                    System.out.print("\nAddress: ");
                    String addressFive = input.nextLine();

                    System.out.print("\nPhone");
                    String phoneFive = input.nextLine();

                    System.out.print("\nPoints:");
                    int pointsFive = Integer.parseInt(input.nextLine());

                    Client clientOptionFive = new Client(idUser,nameFive,lastNameFive,cityFive,addressFive,phoneFive,pointsFive);

                    client.modifyClient(clientOptionFive);

                    System.out.println("\nThe client was modify successfully\n");

                    menu();
                    runApp();
                    break;

                }else {
                    System.out.println("Id client not found, try again");
                    menu();
                    runApp();
                    break;
                }

            case 6:
                System.out.println("Insert id of client to delete: ");
                int idClientDelete = Integer.parseInt(input.nextLine());
                Client clientDelete = new Client(idClientDelete);
                client.deleteClient(clientDelete);
                System.out.println("The client was delete successfully");
                menu();
                runApp();
                break;

            case 7:
                System.out.println("Thank you for used our application");
                break;
        }

    }
}
