package intellipaat;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ReflectionExample extends exampleClass implements testIntf{
	public static void main(String[] args) {
	try{
		exampleClass ex = new exampleClass();
		ReflectionExample re = new ReflectionExample();
		
		System.out.println("Class Name of ex: "+ex.getClass().toString());
		System.out.println("exampleClass package: "+ex.getClass().getPackage());
		System.out.println("super class of ReflectionExample: "+re.getClass().getSuperclass());
		System.out.println("interfaces of ReflectionExample: "+re.getClass().getInterfaces().getClass());
		
		
		//constructing objects by using constructions obtained by reflection
		Constructor constructor = ex.getClass().getDeclaredConstructor();
		System.out.println("no arg constructior: "+constructor.getName());
		exampleClass exNew = (exampleClass) constructor.newInstance();
		exNew.helloTest();
		
		Constructor consWithArgs = ex.getClass().getDeclaredConstructor(new Class[] {String.class, String.class});
		System.out.println("two string args constructior: "+constructor.getName());
		exampleClass exNew1 = (exampleClass) consWithArgs.newInstance("sri","kanth");
		exNew1.helloTest();
		
		//invoking method
		Method met = ex.getClass().getDeclaredMethod("helloTest", String.class);
		met.setAccessible(true);
		met.invoke(exNew1, "Sriknath");
		
		//Getting the constructor with int parameter and invoking
		Method met1 = ex.getClass().getDeclaredMethod("helloTest", int.class);
		met1.invoke(exNew1, 12);
		
	//Reading the generic return type using reflection
		Method method = ex.getClass().getMethod("getStringList", null);

		Type returnType = method.getGenericReturnType();

		if(returnType instanceof ParameterizedType){
		    ParameterizedType type = (ParameterizedType) returnType;
		    Type[] typeArguments = type.getActualTypeArguments();
		    for(Type typeArgument : typeArguments){
		        Class typeArgClass = (Class) typeArgument;
		        System.out.println("typeArgClass = " + typeArgClass);
		    }
		}
		
		
	//--------------------- 
		//Printing the getters and setter methods
		printGettersSetters(ex.getClass());
		
		//Getting all the fields
		Field[] f = ex.getClass().getFields();
		System.out.println("All fields of the class");
		for(Field f1:f){
			System.out.println(" return type: "+f1.getName());
		}		
		
		Field[] fd = ex.getClass().getDeclaredFields();
		System.out.println("All declared fields of the class, gets private fields as well");
		for(Field f1:fd){
			System.out.println(" return type: "+f1.getName());
		}
		
		//Getting all the methods
		Method[] m = ex.getClass().getMethods();
		System.out.println("All methods of the class");
		for(Method m1:m){
			System.out.println(" return type: "+m1.getReturnType()+ " and Name: "+ m1.getName());
		}
		
		Method[] md = ex.getClass().getDeclaredMethods();
		System.out.println("All declared methods of the class, gets private methods as well");
		for(Method m1:md){
			System.out.println(" return type: "+m1.getReturnType()+ " and Name: "+ m1.getName());
		}
		
		//Getting all the constructors
		Constructor[] con = ex.getClass().getConstructors();
		System.out.println("All the constructors");
		for(Constructor c:con){
			System.out.println("Constructor -----");
			Class[] clparams = c.getParameterTypes();
			for(Class cl:clparams)
				System.out.println(cl);
			//System.out.println(" and modifier for it: "+c.getModifiers());
		}
		
		//Getting all the annotations
		Annotation[] annotations = ex.getClass().getAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}
	} catch(Exception e){
		e.printStackTrace();
	}
	}

	@Override
	public void printStrNonStaticAnonymousInnerClassForInterface() {
		// TODO Auto-generated method stub
		
	}
	
	public static void printGettersSetters(Class aClass){
		  Method[] methods = aClass.getDeclaredMethods();

		  for(Method method : methods){
		    if(isGetter(method)) System.out.println("getter: " + method);
		    if(isSetter(method)) System.out.println("setter: " + method);
		  }
		}
	

public static boolean isGetter(Method method){
  if(!method.getName().startsWith("get"))      return false;
  if(method.getParameterTypes().length != 0)   return false;  
  if(void.class.equals(method.getReturnType())) return false;
  return true;
}

public static boolean isSetter(Method method){
  if(!method.getName().startsWith("set")) return false;
  if(method.getParameterTypes().length != 1) return false;
  return true;
}
	
	
}

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE)
@interface MyAnnotation {
    public String name();
    public String value();
}

class TheClass {
	  public static void doSomethingElse(@MyAnnotation(name="aName", value="aValue") String parameter){
	  }
	}

@MyAnnotation(name="SriAnno",value="kanthAnno")
class exampleClass {
	public int num;
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String name;
	private int numPrivate;
	private String namePrivate;
	
	public exampleClass(){
		System.out.println("No args constructor");
	}
	
	public exampleClass(int num, int numPrivate){
		this.num = num;
		this.numPrivate = numPrivate;
		System.out.println("Parameterized constructor with ints");
	}
	
	public exampleClass(String name, String namePrivate){
		this.name = name;
		this.namePrivate = namePrivate;
		System.out.println("Parameterized constructor with two strings: "+name+ " and: "+ namePrivate);
	}
	
	public void helloTest(){
		System.out.println("helloTest void method");
	}
	
	public void helloTest(int i){
		System.out.println("helloTest void method with Input: "+i);
	}
	
	private String helloTest(String str){
		return "helloTest "+str;
	}
	
	  protected List<String> stringList = new ArrayList<>();

	  public List<String> getStringList(){
	    return this.stringList;
	  }
}


interface testInft{}
