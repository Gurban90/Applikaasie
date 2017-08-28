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
        }
    
        public LocalDateTime convertDate(String x){ 
        

            
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       
            localDateTime =  LocalDateTime.parse(x, formatter);
        
        return localDateTime;
    }
    
    public  String convertLocalDateTime(LocalDateTime x)  {
        
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        formatDateTime = x.format(formatter);

        return formatDateTime;
        
       

    }
   
        
       
    
}

