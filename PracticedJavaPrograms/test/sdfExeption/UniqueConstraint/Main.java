package test.sdfExeption.UniqueConstraint;

public class Main {

	  public Main() {
	  }
	  
	    public static void main(String[] args) {
	        Main main = new Main();
	        main.invokedStandalone = true;
	      for (int i = 0; i < 2; i++) {
	       System.out.println();
	        try {
	              main.insert(i);
	        } catch (UniqueConstraintViolationException e) {
	              System.out.println("UniqueConstraintViolationException"); 
	              System.out.println(e.classVersion);
	              System.out.println(e.getMessage());
	        } catch (SdfException e) {
	              System.out.println("SdfException");
	              System.out.println(e.classVersion);
	              System.out.println(e.getMessage());
	        }
	      }  
	        System.out.println("-------------------------------------------------");
	    }
	    
	    public void insert(int n) throws SdfException {
	        SdfException sdfEx = translateSqlMessage("message", n);
	        throw sdfEx;
	    }
	    
	    public SdfException translateSqlMessage(String SqlMessage, int errorNumber) {
	        switch (errorNumber) {
	          case 1: // ORA-00001
	          String[] errorparams = {"x","y"};
	          String   errortext = "unique constraint violation on " +errorparams[0] +" for the following datafield(s): " +errorparams[1];
	          return (new UniqueConstraintViolationException(errortext));
	          default:
	          return (new SdfException(SqlMessage));
	        }
	    }     

	    private boolean invokedStandalone = false;
	}
