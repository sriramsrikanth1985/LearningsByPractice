package com.crunchify.tutorials;
 
/**
 * @author Crunchify.com
 */
 
public class CrunchifyHideStaticMethod {
	public static void main(String args[]) {
		CrunchifyCompany cmp = new CrunchifyCompany();
		// if we can override static, this should call method from Child class
		cmp.staticMethod(); // Eclipse should show warning: The static method
							// staticMethod() from the type Company should be
							// accessed in a static way
		cmp.nonStaticMethod();
	}
}
 
// Comapny: Super-Parent Class
class Company {
 
	// public static method which can not be overridden in Java
	public static void staticMethod() {
		System.out.println("Company: Static Instance method");
	}
 
	// non static method
	public void nonStaticMethod() {
		System.out.println("Company: non-Static method");
	}
}
 
// CrunchifyCompany: Sub-Child Class
class CrunchifyCompany extends Company {
	/*
	 * static method of same name and method signature as existed in super
	 * class, this is not method overriding instead this is called method hiding
	 * in Java
	 */
	public static void staticMethod() {
		System.err.println("CrunchifyCompany: Overridden Static Instance method");
	}
 
	// non static method
	public void nonStaticMethod() {
		System.out.println("CrunchifyCompany: non-Static method");
	}
}