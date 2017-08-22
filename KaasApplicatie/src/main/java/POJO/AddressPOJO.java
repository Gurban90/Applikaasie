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
    private ClientPOJO client;
    private int clientID;
    private AddressTypePOJO addresstype;
    private int addressTypeID;
    private int housenumber;
    private String houseNumberAddition;
    private String streetname;
    private String postalCode;
    private String city;

    public AddressPOJO() {};
      
    public AddressTypePOJO getAddresstype() {
        return addresstype;
    }

    public void setAddresstype(AddressTypePOJO addresstype) {
        this.addresstype = addresstype;
    }

    public ClientPOJO getClient() {
        return client;
    }

    public void setClient(ClientPOJO client) {
        this.client = client;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getHouseNumber() {
        return housenumber;
    }

    public void setHouseNumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public String getHouseNumberAddition() {
        return houseNumberAddition;
    }

    public void setHouseNumberAddition(String houseNumberAddition) {
        this.houseNumberAddition = houseNumberAddition;
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
    
     public int getClientID() {
        return clientID;
    }

    public void setClientID(int ClientID) {
        this.clientID = ClientID;
    }

    public int getAddressTypeID() {
        return addressTypeID;
    }

    public void setAddressTypeID(int addressTypeID) {
        this.addressTypeID = addressTypeID;
    }

    @Override
    public String toString() {
        return "AddressID: " + addressID + ", Housenumber: " + housenumber + ", Housenumber Addition: " + houseNumberAddition + ", Streetname: " + streetname
                + ", Postal Code: " + postalCode + ", City: " + city+", ClientID: " + clientID+", AddressTypeID: " + addressTypeID;
    }

}
