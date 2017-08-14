/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import POJO.CheesePOJO;
import org.apache.commons.validator.routines.IntegerValidator;
import org.apache.commons.validator.GenericValidator;

/**
 *
 * @author Gerben
 */
public class Validator {

    private String Cheesename;

    public void cheeseValidator(String cheese) {
        GenericValidator genericValidator = new GenericValidator();
        this.Cheesename = cheese;
        if (genericValidator.isBlankOrNull(Cheesename)) {
            System.out.println("Leeg");
        } else {
            System.out.println("Niet leeg");
        }
    }

    public static void main(String[] args) {
        Validator valid = new Validator();
        String cheese = "";
        valid.cheeseValidator(cheese);
        
        int number = 0;

        IntegerValidator validator = new IntegerValidator();

        if (validator.isInRange(number, 1, 10)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

}
