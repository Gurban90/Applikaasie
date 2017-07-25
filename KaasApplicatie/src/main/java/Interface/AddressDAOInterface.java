
package Interface;

import POJO.AddressPOJO;
import java.util.List;

public interface AddressDAOInterface {
    
    public Integer addAddress(AddressPOJO adress);
    
    public List<AddressPOJO> getAllAddress();
    
    public AddressPOJO getAddress(AddressPOJO address);
    
    public void updateAddress(int addressID, int housenumber, String houseNumberAddition, String streetname, String postalCode, String city, String deliveryHouseNumber, String deliveryStreetName, String deliveryPostalCode, String deliveryCity);
    
    public void deleteAddress (AddressPOJO address);
}