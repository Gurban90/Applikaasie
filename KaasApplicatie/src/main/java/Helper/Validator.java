/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Menu.CheeseMenu;
import POJO.CheesePOJO;
import java.math.BigDecimal;
import java.util.Scanner;
import org.apache.commons.validator.routines.IntegerValidator;
import org.apache.commons.validator.GenericValidator;
import static org.apache.commons.validator.GenericValidator.isBlankOrNull;
import org.apache.commons.validator.routines.BigDecimalValidator;

/**
 *
 * @author Gerben
 */
public class Validator { //ALLEEN MAINMENU AF! 

    private int intValidation;
    private BigDecimal bdValidation;

    private static Scanner input = new Scanner(System.in);

    public boolean menuValidator(String number) {
        boolean check = true;
        if (isBlankOrNull(number)) {
            check = false;
        } else {
            try {
                this.intValidation = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                check = false;
            }
        }
        return check;
    }

    public boolean idValidator(String id) {
        boolean parsable = true;
        try {
            this.intValidation = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            parsable = false;
        }

        if (parsable == true) {
            IntegerValidator validator = new IntegerValidator();
            return validator.isInRange(intValidation, 1, 1000);
        } else {
            return false;
        }
    }

    public boolean stringValidator(String name) {
        boolean check = true;
        if (isBlankOrNull(name)) {
            check = false;
        }
        return check;
    }

    public boolean priceValidator(String price) { 
        boolean check = true;
        int dot = price.indexOf('.');
        String decimals = price.substring(dot + 1);
        try {
            this.bdValidation = new BigDecimal(price);
        } catch (NumberFormatException e) {
            check = false;
        }
        if (check == true) {
            check = false;
            try {
                decimals.charAt(2);
            } catch (IndexOutOfBoundsException e) {
                check = true;
            }
        }
        if (check == true) {
            BigDecimalValidator bigDecimalValidator = new BigDecimalValidator();
            return bigDecimalValidator.isInRange(bdValidation, 0, 1000);
        } else {
            return false;
        }
    }

    public boolean stockValidator(String stock) {
        boolean parsable = true;
        try {
            this.intValidation = Integer.parseInt(stock);
        } catch (NumberFormatException e) {
            parsable = false;
        }

        if (parsable == true) {
            IntegerValidator validator = new IntegerValidator();
            return validator.isInRange(intValidation, 0, 1000);
        } else {
            return false;
        }
    }
    
    public boolean statusValidator(String status) {
        boolean parsable = true;
        try {
            this.intValidation = Integer.parseInt(status);
        } catch (NumberFormatException e) {
            parsable = false;
        }

        if (parsable == true) {
            IntegerValidator validator = new IntegerValidator();
            return validator.isInRange(intValidation, 0, 5);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String price = "22.00";
        Validator valid = new Validator();
        boolean hoi = valid.priceValidator(price);

        System.out.print(hoi);

    }
}
