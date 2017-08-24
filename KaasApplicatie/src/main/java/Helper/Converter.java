package Helper;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jasper Thielen
 */
public class Converter {
   
    
        public Converter(){
        }
    
        public LocalDateTime convertDate(java.sql.Date x){
        
       Instant y = x.toInstant();
       LocalDateTime z = LocalDateTime.ofInstant(y , ZoneOffset.UTC);
        
        return z;
    }
    
    public  String convertLocalDateTime(LocalDateTime x)  {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = x.format(formatter);

        return formatDateTime;
        
       

    }
   
        
       
    
}

