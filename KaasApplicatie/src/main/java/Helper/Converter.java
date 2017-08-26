package Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jasper Thielen
 */
public class Converter {
   
    
        public Converter(){
        }
    
        public LocalDateTime convertDate(String x){ 
        
            LocalDateTime localDateTime;
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       
          localDateTime =  LocalDateTime.parse(x, formatter);
        
        return localDateTime;
    }
    
    public  String convertLocalDateTime(LocalDateTime x)  {
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = x.format(formatter);

        return formatDateTime;
        
       

    }
   
        
       
    
}

