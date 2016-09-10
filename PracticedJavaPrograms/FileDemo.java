import java.io.File;

public class FileDemo {
   public static void main(String[] args) {
      
      File f = null;
      String v;
      boolean bool = false;
      
      try{
         // create new file
         f = new File("C:\\test\\test.txt");
         
         // get file name or directory name
         v = f.getParent();
                  
         // true if the file path exists
         bool = f.exists();
         
         // if file exists
         if(bool)
         {
            // prints
            System.out.print("parent name: "+v);
         }else {
        	 System.out.println("file path doesnt exists");
         }
         
         File dir = new File("C:\\");
         File[] filelist= dir.listFiles();
         //System.out.println("fileList: "+filelist);
         for(int i=0;i<filelist.length;i++){
        	File n = new File(filelist[i].toString()); 
        	 System.out.println(n+"last modified: "+filelist[i].lastModified());
         }
         
      }catch(Exception e){
         // if any error occurs
         e.printStackTrace();
      }
   }
}