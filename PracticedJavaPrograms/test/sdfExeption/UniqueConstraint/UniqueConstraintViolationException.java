package test.sdfExeption.UniqueConstraint;

public class UniqueConstraintViolationException extends SdfException {

	  public static final String classVersion = "@(#) de.siemens.advantage.in.db.intf.UniqueConstraintViolationException.java : /main/1 : ";

	  public UniqueConstraintViolationException(String msg)
	  {
	    super(msg);
	  }
	}
