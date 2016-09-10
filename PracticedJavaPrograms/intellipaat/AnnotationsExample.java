package intellipaat;

/**
 * Annotations are meta-meta-objects which can be used to describe other meta-objects. Meta-objects are classes, fields and methods. 
 * Asking an object for its meta-object (e.g. anObj.getClass() ) is called introspection. 
 * The introspection can go further and we can ask a meta-object what are its annotations (e.g. aClass.getAnnotations). 
 * Introspection and annotations belong to what is called reflection and meta-programming.
 * 
 * An annotation needs to be interpreted in one way or another to be useful. 
 * Annotations can be interpreted at development-time by the IDE or the compiler, or at run-time by a framework.
 
 * Annotation processing is a very powerful mechanism and can be used in a lot of different ways:
 	to describe constraints or usage of an element: e.g. @Deprecated, @Override, or @NotNull
	to describe the "nature" of an element, e.g. @Entity, @TestCase, @WebService
	to describe the behavior of an element: @Statefull, @Transaction
	to describe how to process the element:  @Column, @XmlElement
	
 * In all cases, an annotation is used to describe the element and clarify its meaning.
 * Prior to JDK5, information that is now expressed with annotations needed to be stored somewhere else, and XML files were frequently used. 
 * But it is more convenient to use annotations because they will belong to the Java code itself, and are hence much easier to manipulate than XML.
 * 
 
 * Usage of annotations:
 	Documentation, e.g. XDoclet
	Compilation
	IDE
	Testing framework, e.g. JUnit
	IoC container e.g. as Spring
	Serialization, e.g. XML
	Aspect-oriented programming (AOP), e.g. Spring AOP
	Application servers, e.g. EJB container, Web Service
	Object-relational mapping (ORM), e.g. Hibernate, JPA
	and many more...
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Inherited --> signals to the compiler that these annotations also should be inherited if any class extends this class
//@custAnno(name="Sri",id=12)
//Above line compilation error since custAnno applicable only to methods i.,e by using Target we achieved
@SuppressWarnings("unused")
public class AnnotationsExample extends test{


	@Deprecated
	static void testMethod(){
		
	}
	@custAnno(name="Sri",id=12)
	@Override
	public void helloMethod(){}
	//If arguments are different, i mean compilation error comes if we are overloading instead of overriding
}

class test{
	public void helloMethod(){}
}

//customer annotations creation
@SuppressWarnings(value = { })
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface custAnno{
	String name();
	int id() default 2;
}
