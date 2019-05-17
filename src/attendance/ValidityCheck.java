/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendance;


// Java program to check if an email address 
// is valid using Regex. 
import java.util.regex.Pattern; 
   
/**
 *
 * @author rewant
 */
public class ValidityCheck {
    
    
     public boolean isValidEmail(String email) 
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
     
     public boolean isValidPhone(String phone){
         String phoneregex = "^[0-9]{10}$";
         Pattern pat = Pattern.compile(phoneregex); 
        if (phone == null) 
            return false; 
        return pat.matcher(phone).matches();  
     }
}
