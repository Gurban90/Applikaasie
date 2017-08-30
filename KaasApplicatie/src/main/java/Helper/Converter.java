package Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Jasper Thielen
 */
public class Converter {

    LocalDateTime localDateTime;
    

    public LocalDateTime convertDate(String x) {
        
        String y = x.substring(0, 19);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        localDateTime = LocalDateTime.parse(y, formatter);

        return localDateTime;
    }

    public String convertLocalDateTime(LocalDateTime x) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = x.format(formatter);

        return formatDateTime;

    }
     public static void main(String[] args) {
         String date = "2017-08-24 00:00:00.0";
         String date2 = "2017-08-08 15:15:12.0";
         String date3 = "2017-08-24 02:02:02";
           
    Converter a = new Converter();
    LocalDateTime b = a.convertDate(date2);
    
    System.out.println(b);
     }
}
