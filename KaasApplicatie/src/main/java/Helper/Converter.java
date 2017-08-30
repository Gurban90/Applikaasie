package Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jasper Thielen
 */
public class Converter {

    LocalDateTime localDateTime;
    

    public LocalDateTime convertDate(String x) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        localDateTime = LocalDateTime.parse(x, formatter);

        return localDateTime;
    }

    public String convertLocalDateTime(LocalDateTime x) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = x.format(formatter);

        return formatDateTime;

    }
     public static void main(String[] args) {
         String date = "2017-08-24 00:00:00.0";
           
    Converter a = new Converter();
    LocalDateTime a = a.convertDate(date);
    
    System.out.println(hoi);
     }
}
