package Interface;


import POJO.AccountPOJO;
import java.util.List;

public interface AccountDAOInterface {
    
    public Integer addAccount(AccountPOJO account);
    
    public List<AccountPOJO> getAllAccount();
    
    public AccountPOJO getAccount(AccountPOJO account);
    
    public void updateAccount(AccountPOJO account);
    
    public boolean deleteAccount (AccountPOJO account);
}
