/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Gerben
 */
//ACCOUNTPOJO
public class AccountPOJO {
    private int accountID;
    private String accountName;
    private String password;
    private int accountStatus;
    
    public AccountPOJO(){}

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return password;
    }

    public void setAccountPassword(String password) {
        this.password = password;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }
    
    @Override
    public String toString(){
        return "AccountID: "+accountID+", AccountName: " +accountName + ", Password: "+password+", AccountStatus: " +accountStatus;
    }
    
            
                    
    
}
