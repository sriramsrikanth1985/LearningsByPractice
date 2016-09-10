import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Date;


class ThreadExampleExtn extends Thread {
	public void run(){
		System.out.println("in run method"+Thread.currentThread().getId());
		
	    boolean _doHousekeeping = false;
	    
	    File lockFile = null;
	    try {
	      // if lock is successful then set the flag to true    
	      String lockFileName = "C\\:Test\\abc.txt";//_configLoader.getControlDirectory().concat(File.separator).concat(IOffCSConstants.LOCKFILE_HOUSEKEEPING);
	      lockFile = new File(lockFileName);
	      
	      long currentTime = new Date().getTime();
	  	  String myId = this.getId()+"123";
	      
	      String firstLine = getLock(lockFileName, myId, currentTime);
	      String firstId = "";
	      long lastModified = 0;
	      
	      if (firstLine != null) {
	    	 firstId = firstLine.split(",")[0];
	    	 lastModified = Long.parseLong(firstLine.split(",")[1]);
	      }	
	      
	      System.out.println("myId:"+myId+" currentTime: "+currentTime+" firstLine: "+firstLine+" firstId: "+firstId+" lastModified: "+lastModified);
	      
	      if (myId.equals(firstId)) {
	        _doHousekeeping = true;
	      } else {
	        // if it is old enough then remove the lock file
	        long timePeriod = 1000 * 1;
	      
	        if (currentTime - lastModified > timePeriod) {
	          if (lockFile.exists()) {        
	            lockFile.delete();
	            System.out.println("Outdated lock file has been deleted ");
	           // _traceSupport.traceInfo(traceHeader, "Outdated lock file has been deleted " + IOffCSConstants.LOCKFILE_HOUSEKEEPING);
	           // _container.supervision().notifyError(_componentHandle,
	                 //   IFrwSupervision.ERROR_APPLICATION, IFrwSupervision.SEVERITY_MINOR, IOffCSConstants.ADHOC_ERROR_ID,
	                 //   "Outdated lock file has been deleted " + IOffCSConstants.LOCKFILE_HOUSEKEEPING);
	            
	          }
	        }
	      }
	    } catch (Exception e) {
	        System.out.println("Exception caught: "+e.getMessage());
	        //_container.supervision().notifyError(_componentHandle,
	               // IFrwSupervision.ERROR_APPLICATION, IFrwSupervision.SEVERITY_MINOR, IOffCSConstants.ADHOC_ERROR_ID,
	                //" exception in OffCSWorker.setHousekeepingFlag(): " + e.getMessage());
	        if ((lockFile != null) && (lockFile.exists())) {        
	            lockFile.delete();
	            //_traceSupport.traceInfo(traceHeader, "Failed lock file has been deleted " + IOffCSConstants.LOCKFILE_HOUSEKEEPING);
	           // _container.supervision().notifyError(_componentHandle,
	             //       IFrwSupervision.ERROR_APPLICATION, IFrwSupervision.SEVERITY_MINOR, IOffCSConstants.ADHOC_ERROR_ID,
	             //       "Failed lock file has been deleted " + IOffCSConstants.LOCKFILE_HOUSEKEEPING);   
	            System.out.println("Failed lock file has been deleted ");
	         }                
	    }  
	}
	
	  private String getLock(String fileName, String myId, long currentTime) {
		    final String traceHeader = "OffCSWorker.getLock";
		    //_traceSupport.traceBasicEnter(traceHeader);
		    System.out.println("Enter "+traceHeader);
		                    
		    FileWriter osLock = null;
		    BufferedWriter bosLock = null;
		    LineNumberReader reader = null;
		    String line = null;
		    

		    // write my id and current time to the lock file
		    try {
		    	
		      osLock = new FileWriter(fileName, true);
		      bosLock = new BufferedWriter(osLock);
		      
		      StringBuffer sb = new StringBuffer(myId);
		      sb.append(",");
		      sb.append(currentTime);
		      
		      bosLock.write(sb.toString());
		      bosLock.write("\n");
		      bosLock.flush();
		    } catch (IOException ioe) {
		      //_traceSupport.traceException(traceHeader, "Exception at getLock: ", ioe);
		    	System.out.println("Exception at getLock1: "+ioe.getMessage());
		    	ioe.printStackTrace();
		      // _container.supervision().notifyError(_componentHandle,
		      //        IFrwSupervision.ERROR_APPLICATION, IFrwSupervision.SEVERITY_MINOR, IOffCSConstants.ADHOC_ERROR_ID,
		      //        " exception in OffCSWorker.getLock(): " + ioe.getMessage());
		    } finally {
		      try {
		        if (bosLock != null) {
		          bosLock.close();
		        }
		      } catch (IOException ioe) {
		        //_traceSupport.traceException(traceHeader, "Exception at getLock: ", ioe);
		    	  System.out.println("Exception at getLock2: "+ioe.getMessage());
		        //_container.supervision().notifyError(_componentHandle,
		        //        IFrwSupervision.ERROR_APPLICATION, IFrwSupervision.SEVERITY_MINOR, IOffCSConstants.ADHOC_ERROR_ID,
		        //        " exception in OffCSWorker.getLock(): " + ioe.getMessage());
		      }    
		    } 
		      
		    // read out first line
		    try {
		      reader = new LineNumberReader(new FileReader(fileName));
		      line = reader.readLine();
		      
		      if (line != null) {
		        line = line.trim();
		      }
		    } catch (IOException ioe) {
		      //_traceSupport.traceException(traceHeader, "Exception at getLock: ", ioe);
		    	System.out.println("Exception at getLock3: "+ioe.getMessage());
		    	ioe.printStackTrace();
		      // _container.supervision().notifyError(_componentHandle,
		      //        IFrwSupervision.ERROR_APPLICATION, IFrwSupervision.SEVERITY_MINOR, IOffCSConstants.ADHOC_ERROR_ID,
		      //        " exception in OffCSWorker.getLock(): " + ioe.getMessage());
		    } finally {      
		      try {
		        if (reader != null) {
		          reader.close();
		        }
		      } catch (IOException ioe) {
		        //_traceSupport.traceException(traceHeader, "Exception at getLock: ", ioe);
		        System.out.println("Exception at getLock4: "+ioe.getMessage());
		        //_container.supervision().notifyError(_componentHandle,
		        //        IFrwSupervision.ERROR_APPLICATION, IFrwSupervision.SEVERITY_MINOR, IOffCSConstants.ADHOC_ERROR_ID,
		        //        " exception in OffCSWorker.getLock(): " + ioe.getMessage());
		      }
		    }
		        
		    //_traceSupport.traceBasicLeave(traceHeader);
		    System.out.println("Leave "+traceHeader);
		    return line;
		  }
}