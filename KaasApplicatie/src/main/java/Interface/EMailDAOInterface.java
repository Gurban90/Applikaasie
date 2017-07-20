/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import POJO.EMailPOJO;
import java.util.List;

/**
 *
 * @author Gerben
 */
public interface EMailDAOInterface {

    public Integer addEMail(EMailPOJO email);

    public List<EMailPOJO> getAllEMial();

    public EMailPOJO getEMail(EMailPOJO email);

    public void updateEMail(EMailPOJO email);

    public void deleteEMail(EMailPOJO email);

}
