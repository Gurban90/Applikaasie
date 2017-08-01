
package POJO;

/**
 *
 * @author Jasper Thielen
 */
public class AddressTypePOJO {
    
    private int addressTypeID;
    private int addressType;
    
    public AddressTypePOJO(){};
    
    public int getAddressTypeID(){
	return addressTypeID;
    }
    public void setAddressTypeID(int addressTypeID) {
        this.addressTypeID = addressTypeID;
    }
    public int getAddressType(){
	return addressType;
    }
    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }
}
