package recursive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javassist.bytecode.Descriptor.Iterator;

public class FileRead {
	
	  private HashMap<String,String> readAllDescriptionLines(LineNumberReader reader, HashMap<String,String> descLines){
		  try {
			  StringTokenizer Tok = null;
			  String key = null;
			  String line = reader.readLine();
			  String suffix = "OFF::Charge:CDR";
			  while( line != null){
				  Tok = new StringTokenizer(line,"(");
		    		key = Tok.nextElement().toString();
		    		if(key.endsWith(suffix)){
		    			String replacedKey = key.replaceFirst(suffix, "");
		    			String modifiedValue = suffix.concat(Tok.nextToken(";"));
		    			System.out.println("replacedKey: "+replacedKey+" modifiedValue: "+modifiedValue);
		    			/*StringBuffer replacedModifiedValue = new StringBuffer();
		    			String[] tokens = modifiedValue.split(",");
		    			int fieldPosition = 0;
		    			while(fieldPosition < tokens.length){
		    				if(fieldPosition == 8){
		    					replacedModifiedValue.append("Timestamp_End,");
		    				}
		    				else
		    					replacedModifiedValue.append(tokens[fieldPosition]+",");
		    				fieldPosition++;
		    			}
		    			System.out.println("replacedKey: "+replacedKey+" replacedModifiedValue: "+replacedModifiedValue.toString());*/
			    		descLines.put(replacedKey, modifiedValue.toString());
		    		}
		    		line = reader.readLine();
			  }
			  
			  /*java.util.Iterator<String> itr = descLines.keySet().iterator();
			  String hashKey = null;
			  while(itr.hasNext()){
				  hashKey = itr.next();
				  System.out.println("key: "+hashKey+" Value: "+descLines.get(hashKey));
			  }*/
			 // Set<String> entrySet = descLines.keySet();
			  Set<Map.Entry<String,String>> entrySet = descLines.entrySet();
			  for(Map.Entry<String,String> entry:entrySet){
				  System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
			  }

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return descLines;
	  }
	  
		private String readLinesFromTciCsv(LineNumberReader reader, StringBuffer line, String key){
			String traceHeader = "OffCSWorker.readLinesFromTciCsv()";
			String readline = null;
			  try {
				  System.out.println(" getLineNumber before: "+reader.getLineNumber());
				readline = reader.readLine();
				if(!readline.contains("OFF::Charge:CDR")){
					if(readline.contains(key)) {
						System.out.println(" getLineNumber after: "+reader.getLineNumber());
						line.append(readline.replaceFirst(key, ""));
						readline = readLinesFromTciCsv(reader, line, key);
					} else
						return readline;
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
				return readline;
		  }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileRead fr = new FileRead();

		LineNumberReader reader;
		try {
			reader = new LineNumberReader(new FileReader("C:\\test\\testing.txt"));
			String line;
			
			HashMap<String,String> descriptionLines = new HashMap<String,String>();
			fr.readAllDescriptionLines(reader,descriptionLines);
			/*line = reader.readLine();
			//while((line = reader.readLine())!= null){
				StringTokenizer Tok = new StringTokenizer(line,"(");
				String searchString = Tok.nextElement().toString();
				
				StringBuffer sbline = new StringBuffer(line.replaceFirst(searchString, ""));
				//System.out.println("capacity: "+sbline.capacity());
				//System.out.println("lenght: "+sbline.length());

				String newline = fr.readLinesFromTciCsv(reader, sbline, searchString);
				System.out.println("newline: "+newline);
				System.out.println("sbline: "+sbline);
			//}*/
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
