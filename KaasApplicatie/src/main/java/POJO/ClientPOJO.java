/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Gerben
 */
//OPZET CLIENTPOJO
public class ClientPOJO {
    private int    clientID;
    private String firstName;
    private String lastName;
    private String eMail;
       
    public ClientPOJO() {}


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
    
        public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getEMail() {
    return eMail;
    }
}
