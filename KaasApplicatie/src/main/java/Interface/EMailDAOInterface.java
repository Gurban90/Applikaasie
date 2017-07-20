package Interface;



import POJO.EMailPOJO;
import java.util.List;

public interface EMailDAOInterface {
    
    public Integer addEMail(EMailPOJO email);
    
    public List<EMailPOJO> getAllEMial();
    
    public EMailPOJO getEMail(EMailPOJO email);
    
    public void updateEMail(EMailPOJO email);
    
    public boolean deleteEMail (EMailPOJO email);
}
