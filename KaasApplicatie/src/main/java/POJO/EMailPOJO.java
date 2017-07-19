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
//EMAIL POJO
public class EMailPOJO {
    private int eMailID;
    private String eMail;
    
    public EMailPOJO(){};
    
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getEMail() {
    return eMail;
    }
    public void setEMailID(int eMailID) {
        this.eMailID = eMailID;
    }

    public int getEMailID() {
    return eMailID;
    }
}

