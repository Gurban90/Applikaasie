package Menu;

import Controller.ClientController;
import Helper.Validator;
import POJO.ClientPOJO;
import java.util.*;
import java.util.logging.Logger;

public class ClientMenu {

    static final Logger LOGGER = Logger.getLogger(ClientMenu.class.getName());

    private Scanner input;
    private int choice;
    private int editChoice;
    private int searchChoice;
    private int clientID;
    private String firstName;
    private String lastName;
    private String eMail;
    private String anwser;
    private String ClientIDString;
    ClientPOJO returnedClient;
    List<ClientPOJO> returnedClientList;
    Validator validator = new Validator();

    private ClientController controller = new ClientController();

    public void clientMenu() {

        LOGGER.info("clientMenu start");

        input = new Scanner(System.in);

        System.out.print(" Client menu: " + "\n"
                + "1. New Client" + "\n"
                + "2. Remove Client" + "\n"
                + "3. Edit Client" + "\n"
                + "4. Search Client" + "\n"
                + "5. Return to last menu" + "\n"
                + "Please enter your choice: ");

        String choiceNumber = input.nextLine();
        if (validator.menuValidator(choiceNumber)) {

            choice = Integer.parseInt(choiceNumber);

            switch (choice) {
                case 1:
                    LOGGER.info("newClient start");

                    System.out.print("Insert Client First Name: ");
                    firstName = input.nextLine();
                    if (validator.stringValidator(firstName)) {

                        System.out.print("Insert Client Last Name: ");
                        lastName = input.nextLine();
                        if (validator.stringValidator(lastName)) {

                            System.out.print("Insert Client email: ");
                            eMail = input.nextLine();
                            if (validator.eMailValidator(eMail)) {

                                clientID = controller.newClient(this.firstName, this.lastName, this.eMail);
                                System.out.println("New Client added with the ClientID of: " + clientID);

                                clientMenu();
                                LOGGER.info("newClient end");
                            } else {
                                System.out.println("E-mail must be a valid e-mail address.  ");
                                clientMenu();
                            }
                        } else {
                            System.out.println("Last Name cannot be empty. ");
                            clientMenu();
                        }
                    } else {
                        System.out.println("First Name cannot be empty. ");
                        clientMenu();
                    }
                    break;
                case 2:
                    LOGGER.info("removeClient start");
                    System.out.print("Enter The clientID you want to remove: ");
                    ClientIDString = input.nextLine();
                    if (validator.idValidator(this.ClientIDString)) {
                        clientID = Integer.parseInt(this.ClientIDString);

                        System.out.println("Are You Sure you want to remove clientID: " + clientID + "  enter Yes ");
                        anwser = input.next();

                        controller.removeClient(clientID, anwser);

                        LOGGER.info("removeClient end");
                        clientMenu();
                    } else {
                        System.out.println("ClientID must be an integer and between 1 and 1000. ");
                        clientMenu();
                    }
                    break;
                case 3:
                    editClientMenu();
                    break;

                case 4:
                    searchClientMenu();
                    break;

                case 5:
                    LOGGER.info("Open MainMenu");
                    MainMenu mainmenu = new MainMenu();
                    mainmenu.mainMenu();
                    break;
                default:
                    System.out.println("wrong number, try again");
                    clientMenu();

            }
            LOGGER.info("clientMenu end");
        } else {
            System.out.println("Choice must be an integer. ");
            clientMenu();
        }
    }

    public void editClientMenu() {

        System.out.print(" Client menu: " + "\n"
                + "1. Show all clients" + "\n"
                + "2. Alter first Name" + "\n"
                + "3. Alter last Name" + "\n"
                + "4. alter email" + "\n"
                + "5. edit all" + "\n"
                + "6. Return to last menu" + "\n"
                + "Please enter your choice: ");

        String choiceNumber2 = input.nextLine();
        if (validator.menuValidator(choiceNumber2)) {

            editChoice = Integer.parseInt(choiceNumber2);

            switch (editChoice) {

                case 1:
                    LOGGER.info("showallClient start");
                    System.out.print("Show all clients");
                    controller = new ClientController();
                    System.out.println(controller.getAllClients());
                    LOGGER.info("showallClient start");

                    clientMenu();
                    break;
                case 2:
                    System.out.print("Insert ClientID: ");
                    ClientIDString = input.nextLine();
                    if (validator.idValidator(this.ClientIDString)) {
                        clientID = Integer.parseInt(this.ClientIDString);

                        System.out.print("Insert new First Name: ");
                        this.firstName = input.nextLine();
                        if (validator.stringValidator(this.firstName)) {

                            controller = new ClientController();
                            System.out.println(controller.editClientFirstName(clientID, firstName));

                            clientMenu();
                        } else {
                            System.out.println("First Name cannot be empty. ");
                            editClientMenu();
                        }
                    } else {
                        System.out.println("ClientID must be an integer and between 1 and 1000. ");
                        editClientMenu();
                    }
                    break;
                case 3:
                    System.out.print("Insert ClientID: ");
                    ClientIDString = input.nextLine();
                    if (validator.idValidator(this.ClientIDString)) {
                        clientID = Integer.parseInt(this.ClientIDString);
                        System.out.print("Insert last Name: ");
                        this.lastName = input.nextLine();
                        if (validator.stringValidator(this.lastName)) {

                            controller = new ClientController();
                            System.out.println(controller.editClientLastName(clientID, lastName));

                            clientMenu();
                        } else {
                            System.out.println("Last Name cannot be empty. ");
                            editClientMenu();
                        }
                    } else {
                        System.out.println("ClientID must be an integer and between 1 and 1000. ");
                        editClientMenu();
                    }
                    break;
                case 4:
                    System.out.print("Insert ClientID: ");
                    ClientIDString = input.nextLine();
                    if (validator.idValidator(this.ClientIDString)) {
                        clientID = Integer.parseInt(this.ClientIDString);
                        System.out.print("Insert eMail: ");
                        eMail = input.nextLine();
                        if (validator.eMailValidator(eMail)) {

                            controller = new ClientController();
                            System.out.println(controller.editClientEMail(clientID, eMail));
                            clientMenu();
                        } else {
                            System.out.println("E-mail must be a valid e-mail address. ");
                            editClientMenu();
                        }
                    } else {
                        System.out.println("ClientID must be an integer and between 1 and 1000. ");
                        editClientMenu();
                    }
                    break;

                case 5:
                    LOGGER.info("editClient start");
                    System.out.println("Insert client ID to search Client: ");
                    ClientIDString = input.nextLine();
                    if (validator.idValidator(this.ClientIDString)) {
                        this.clientID = Integer.parseInt(this.ClientIDString);
                        System.out.print("Insert Client First Name: ");
                        this.firstName = input.nextLine();
                        if (validator.stringValidator(this.firstName)) {
                            System.out.print("Insert Client Last Name: ");
                            this.lastName = input.nextLine();
                            if (validator.stringValidator(this.lastName)) {
                                System.out.print("Insert Client email");
                                this.eMail = input.nextLine();
                                if (validator.eMailValidator(this.eMail)) {

                                    controller.editClient(clientID, this.firstName, this.lastName, this.eMail);
                                    LOGGER.info("editClient end");

                                    clientMenu();
                                } else {
                                    System.out.println("E-mail must be a valid e-mail address. ");
                                    editClientMenu();
                                }
                            } else {
                                System.out.println("Last Name cannot be empty. ");
                                editClientMenu();
                            }
                        } else {
                            System.out.println("First Name cannot be empty. ");
                            editClientMenu();
                        }
                    } else {
                        System.out.println("ClientID must be an integer and between 1 and 1000. ");
                        editClientMenu();
                    }
                    break;

                case 6:
                    clientMenu();
                    break;
                default:
                    System.out.println("wrong number, try again");
                    editClientMenu();
            }
            LOGGER.info("editclientMenu end");
        } else {
            System.out.println("Choice must be an integer. ");
            editClientMenu();
        }
    }

    public void searchClientMenu() {

        System.out.print(" Client menu: " + "\n"
                + "1. Show all clients" + "\n"
                + "2. Search on ID" + "\n"
                + "3. Search on firstName" + "\n"
                + "4 Search on lastName" + "\n"
                + "5 search on eMail" + "\n"
                + "5. Return to last menu" + "\n"
                + "Please enter your choice: ");

        String choiceNumber3 = input.nextLine();
        if (validator.menuValidator(choiceNumber3)) {

            searchChoice = Integer.parseInt(choiceNumber3);

            switch (searchChoice) {

                case 1:
                    LOGGER.info("showallClient start");
                    System.out.print("Show all clients");
                    controller = new ClientController();
                    System.out.println(controller.getAllClients());
                    LOGGER.info("showallClient start");

                    clientMenu();
                    break;
                case 2:
                    System.out.print("clientID please: ");
                    ClientIDString = input.nextLine();
                    if (validator.idValidator(this.ClientIDString)) {
                        this.clientID = Integer.parseInt(this.ClientIDString);

                        controller = new ClientController();
                        this.returnedClient = controller.findClientWithID(clientID);
                        System.out.println(returnedClient);

                        clientMenu();
                    } else {
                        System.out.println("ClientID must be an integer and between 1 and 1000. ");
                        searchClientMenu();
                    }
                    break;
                case 3:
                    System.out.print("firstName please: ");
                    this.firstName = input.nextLine();
                    if (validator.stringValidator(this.firstName)) {

                        controller = new ClientController();
                        this.returnedClientList = controller.findClientWithFirstName(firstName);

                        for (ClientPOJO printList : returnedClientList) {
                            System.out.println(printList.getClientID());
                            System.out.println(printList.getFirstName());
                            System.out.println(printList.getLastName());
                            System.out.println(printList.getEMail());

                        }

                        clientMenu();
                    } else {
                        System.out.println("First Name cannot be empty. ");
                        searchClientMenu();
                    }
                    break;
                case 4:
                    System.out.print("lastName please: ");
                    this.lastName = input.nextLine();
                    if (validator.stringValidator(this.lastName)) {

                        controller = new ClientController();
                        this.returnedClientList = controller.findClientWithLastName(lastName);

                        for (ClientPOJO printList : returnedClientList) {
                            System.out.println(printList.getClientID());
                            System.out.println(printList.getFirstName());
                            System.out.println(printList.getLastName());
                            System.out.println(printList.getEMail());

                        }

                        clientMenu();
                    } else {
                        System.out.println("Last Name cannot be empty. ");
                        searchClientMenu();
                    }
                    break;
                case 5:
                    System.out.print("eMail please: ");
                    this.eMail = input.nextLine();
                    if (validator.eMailValidator(this.eMail)) {

                        controller = new ClientController();
                        this.returnedClientList = controller.findClientWithEMail(eMail);

                        for (ClientPOJO printList : returnedClientList) {
                            System.out.println(printList.getClientID());
                            System.out.println(printList.getFirstName());
                            System.out.println(printList.getLastName());
                            System.out.println(printList.getEMail());

                        }

                        clientMenu();
                    } else {
                        System.out.println("E-mail must be a valid e-mail address. ");
                        searchClientMenu();
                    }
                    break;
                case 6:
                    clientMenu();
                    break;
                default:
                    System.out.println("wrong number, try again");
                    searchClientMenu();
            }
        } else {
            System.out.println("Choice must be an integer. ");
            searchClientMenu();
        }
    }
}
