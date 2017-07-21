
package Interface;

import POJO.ClientPOJO;
import java.util.List;


public interface ClientDAOInterface {
    
    public Integer AddClient(ClientPOJO client);
    
    public List<ClientPOJO> getAllClient();
    
    public ClientPOJO getClient(ClientPOJO client);
    
    public void updateClient(ClientPOJO client);
    
    public boolean deleteClient (ClientPOJO client);
    
}  

