
package Interface;

import POJO.AddressPOJO;
import POJO.AddressTypePOJO;
import java.util.List;

public interface AddressDAOInterface {
    
    public Integer addAddress(AddressPOJO adress);
    
    public List<AddressPOJO> getAllAddress();
    
    public AddressPOJO getAddress(AddressPOJO address);
    
    public void updateAddress(AddressPOJO address);
    
    public void deleteAddress (AddressPOJO address);
    
    public Integer addAddressType(AddressTypePOJO adress);
    
    public List<AddressTypePOJO> getAllAddressType();
    
    public AddressTypePOJO getAddressType(AddressTypePOJO address);
    
    public void updateAddressType(AddressTypePOJO address);
    
    public void deleteAddressType (AddressTypePOJO address);
}