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
    LocalDateTime x = LocalDateTime.now();
    Converter a = new Converter();
    String hoi = a.convertLocalDateTime(x);
    System.out.println(hoi);
     }
}
