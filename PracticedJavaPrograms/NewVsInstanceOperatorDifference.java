import java.lang.reflect.ReflectPermission;
public class NewVsInstanceOperatorDifference {
	
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	
	String str = new String();
	
	str = "java.lang.reflect.ReflectPermission";
	
	//at run time
	Object obj = Class.forName(str).newInstance();
	System.out.println(obj.getClass());
	}

}
