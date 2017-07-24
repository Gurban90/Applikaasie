package Interface;

import POJO.ClientPOJO;
import java.util.List;

public interface ClientDAOInterface {

    public Integer AddClient(ClientPOJO client);

    public List<ClientPOJO> getAllClient();

    public List<ClientPOJO> getClient(ClientPOJO client);

    public List<ClientPOJO> getClientWithFirstName(String FirstName);

    public List<ClientPOJO> getClientWithLastName(String LastName);

    public List<ClientPOJO> getClientWithEmail(String Email);

    public void updateClient(ClientPOJO client);

    public void updateClientFirstName(Integer ClientID, String FirstName);

    public void updateClientLastName(Integer ClientID, String LastName);

    public void updateClientEmail(Integer ClientID, String Email);

    public void deleteClient(ClientPOJO client);

}
