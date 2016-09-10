package hashMapImpl;

import java.util.HashMap;                                                         
import java.util.Iterator;                                                        
                                                                                  
public class HashMapStructure {                                                   
                                                                                  
    /**                                                                           
     * @author Arpit Mandliya                                                     
     */                                                                           
    public static void main(String[] args) {                                      
                                                                                  
        Country india=new Country("India",1000);                                  
        Country japan=new Country("Japan",2000);                                 
                                                                                  
        Country butan=new Country("Butan",3000);    
        
        System.out.println("hash value of india: "+india.hashCode());
                                                                                  
        HashMap<Country,String> countryCapitalMap=new HashMap<Country,String>();  
        countryCapitalMap.put(india,"Delhi");                                     
        countryCapitalMap.put(japan,"Tokyo");                                     
        countryCapitalMap.put(butan,"xyz");                                    
        
        Iterator<Country> countryCapitalIter=countryCapitalMap.keySet().iterator();//put debug point at this line       
        while(countryCapitalIter.hasNext())                                                                             
        {                                                                                                               
            Country countryObj=countryCapitalIter.next();                                                               
            String capital=countryCapitalMap.get(countryObj);                                                           
            System.out.println(countryObj.getName()+"----"+capital);                                                    
            }                                                                                                           
        }                                                                                                               
}

