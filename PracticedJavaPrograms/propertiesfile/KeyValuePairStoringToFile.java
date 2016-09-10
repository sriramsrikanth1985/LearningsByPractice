package propertiesfile;


import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.util.Enumeration;  
import java.util.Properties;  
  
/** 
 *  
 * @author Anuj 
 * 
 */  
public class KeyValuePairStoringToFile {  
 public static void main(String[] args) {  
  
  Properties properties = new Properties();  
  try {  
   File file = new File("C:\\test\\abc_123.txt");  
   FileInputStream fileInputStream = new FileInputStream(file);  
  
   //load properties file  
   properties.load(fileInputStream);  
  
/*   System.out.println("keys avialble in Properties Files are:");  
   System.out.println(properties.keySet());  
  
   System.out.println("Key Value Pairs :");  
   Enumeration enumeration = properties.keys();  
   while (enumeration.hasMoreElements()) {  
    String key = (String) enumeration.nextElement();  
    System.out.println(key + ": " + properties.get(key));  
   } */ 
   System.out.println(properties.get("abc"));
  } catch (IOException e) {  
   System.out.println(e.getMessage());  
  }  
 }  
} 
