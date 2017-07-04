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
//OPZET CLIENT
public class Client {
    private int    clientNumber;
    private String firstName;
    private String lastName;
    private String streetname;
    private String housenumber;
    private String postalCode;
    private String city;
    private String e_Mail;
    private String deliveryStreetName;
    private String deliveryPostalCode;
    private String deliveryCity;

   
    public Client() {}


    public int getClientNumber(){
	return clientNumber;
    }
    public void setClientNumber(int clientNumber) {
	this.clientNumber = clientNumber;
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


    public String getStreetname() {
	return streetname;
    }
    public void setStreetname(String streetname) {
	this.streetname = streetname;
    }


    public String getHouseNumber() {
	return housenumber;
    }
    public void setHouseNumber(String housenumber) {
	this.housenumber = housenumber;
       }


    public String getPostalCode() {
	return postalCode;
    }
    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }


    public String getCity() {
	return postalCode;
    }
    public void setCity(String city) {
	this.city = city;
    }

    public void setE_Mail(String e_Mail) {
        this.e_Mail = e_Mail;
    }

    public String getE_Mail() {
    return e_Mail;
    }


    public String getDeliveryStreetName() {
        return deliveryStreetName;
    }
    public void setDeliveryStreetName(String deliveryStreetName) {
        this.deliveryStreetName = deliveryStreetName;
    }

    
    public String getDeliveryPostalCode() {
        return deliveryPostalCode;
    }
    public void setDeliveryPostalCode(String deliveryPostalCode) {
        this.deliveryPostalCode = deliveryPostalCode;
    }

    
    public String getDeliveryCity() {
        return deliveryCity;
    }
    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }
    
    public void removeClient(){
        //DELETE CLIENT FROM DATABASE
    }

    @Override
    public String toString(){
	return "Client ID " + clientNumber + ". Client data: " + firstName + " " + lastName + " " + streetname + " " + housenumber + " " + postalCode + " " 
                + city + " " + e_Mail + " " + deliveryStreetName + " " + deliveryPostalCode + " " + deliveryCity; 
}
}
