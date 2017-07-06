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
//ADDRESS POJO
public class AddressPOJO {
    private String streetname;
    private String housenumber;
    private String postalCode;
    private String city;
    private String deliveryStreetName;
    private String deliveryPostalCode;
    private String deliveryCity;
    
    public AddressPOJO(){};
    
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
