package Helper;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
    
    public java.sql.Date convertLocalDateTime(LocalDateTime x)  {
        
        Instant y = x.toInstant(ZoneOffset.UTC);
        Date z = (java.sql.Date)Date.from(y);
        
        
        return z;

    }
}
