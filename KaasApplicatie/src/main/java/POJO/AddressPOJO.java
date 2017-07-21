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
//ADDRESS POJO
public class AddressPOJO {
    
    private int addressID;
    
    private String housenumber;
    private String streetname;
    private String postalCode;
    private String city;
    
    private String deliveryHouseNumber;
    private String deliveryStreetName;
    private String deliveryPostalCode;
    private String deliveryCity;
    
    public AddressPOJO(){};
    
    public int getAddressID(){
	return addressID;
    }
    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }
    
    
    
    public String getHouseNumber() {
        return housenumber;
    }
    
    public void setHouseNumber(String housenumber) {
	this.housenumber = housenumber;
       }
    
    public String getStreetName() {
	return streetname;
    }
    public void setStreetName(String streetname) {
	this.streetname = streetname;
    }

    public String getPostalCode() {
	return postalCode;
    }
    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }


    public String getCity() {
	return city;
    }
    public void setCity(String city) {
	this.city = city;
    }
    
    //And now the delivery....
    
    
    public String getDeliveryHouseNumber() {
        return deliveryHouseNumber;
    }
    
    public void setDeliveryHouseNumber(String deliveryhousenumber) {
	this.deliveryHouseNumber = deliveryhousenumber;
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
    
       
   
}
