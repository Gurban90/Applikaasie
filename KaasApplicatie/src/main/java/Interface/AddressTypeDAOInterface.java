
package Interface;

import POJO.AddressTypePOJO;
import java.util.List;

public interface AddressTypeDAOInterface {
    
    public Integer addAddressType(AddressTypePOJO adress);
    
    public List<AddressTypePOJO> getAllAddressType();
    
    public AddressTypePOJO getAddressType(AddressTypePOJO address);
    
    public void updateAddressType(Integer AddressTypeID, String AddressType);
    
    public void deleteAddressType (AddressTypePOJO address);
    
}
