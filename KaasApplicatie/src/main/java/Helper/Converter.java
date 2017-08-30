package Helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jasper Thielen
 */
public class Converter {
   
            LocalDateTime localDateTime;
            DateTimeFormatter formatter;
            String formatDateTime;
            
    
        public Converter(){
        
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        }
    
        public LocalDateTime convertDate(String x){ 
       
            localDateTime =  LocalDateTime.parse(x, formatter);
        
        return localDateTime;
    }
    
    public  String convertLocalDateTime(LocalDateTime x)  {
        
        formatDateTime = x.format(formatter);

        return formatDateTime;
        
       

    }
   
        
       
    
}

