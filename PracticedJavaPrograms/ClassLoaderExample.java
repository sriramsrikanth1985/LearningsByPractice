import java.lang.reflect.Method;

import hashMapImpl.Country;

public class ClassLoaderExample {
	public static void main(String args[]){
		try {
			Class cla = ClassLoader.getSystemClassLoader().loadClass("CharArray");
			CharArray ca = new CharArray();
			System.out.println("aClass.getName() = " + cla.getName());
			
			String className = "hashMapImpl.Country";
			Class<?> country = ClassLoader.getSystemClassLoader().loadClass(className);
			Method[] methods = country.getClass().getMethods();
			System.out.println("printing all the methods:");
			for(Method method:methods){
				System.out.println(method.getName());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
