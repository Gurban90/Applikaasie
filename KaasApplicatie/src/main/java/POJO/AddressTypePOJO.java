
package POJO;

/**
 *
 * @author Jasper Thielen
 */
public class AddressTypePOJO {
    
    private int addressTypeID;
    private String addressType;
    
    public AddressTypePOJO(){};
    
    public int getAddressTypeID(){
	return addressTypeID;
    }
    public void setAddressTypeID(int addressTypeID) {
        this.addressTypeID = addressTypeID;
    }
    public String getAddressType(){
	return addressType;
    }
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
}
