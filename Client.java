/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSvier;

/**
 *
 * @author Gerben
 */
//OPZET CLIENTPOJO
public class Client {
    private int    clientID;
    private String firstName;
    private String lastName;
       
    public Client() {}


    public int getClientID(){
	return clientID;
    }
    public void setClientID(int clientID) {
	this.clientID = clientID;
    }


    public String getFirstName() {
	return firstName;
    }
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }


    public String getLastName() {
	return lastName;
    }
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    

   
}
