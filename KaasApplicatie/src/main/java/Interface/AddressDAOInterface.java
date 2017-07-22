/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;



import POJO.AddressPOJO;
import java.util.List;

public interface AddressDAOInterface {
    
    public Integer addAddress(AddressPOJO adress);
    
    public List<AddressPOJO> getAllAddress();
    
    public AddressPOJO getAddress(AddressPOJO address);
    
    public void updateAddress(AddressPOJO address);
    
    public void deleteAddress (AddressPOJO address);
}