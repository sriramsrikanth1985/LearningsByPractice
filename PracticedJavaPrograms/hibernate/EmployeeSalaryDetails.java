package hibernate;

import java.io.Serializable;

public class EmployeeSalaryDetails implements Serializable {

	//All the table columns mapping to corresponding type variable, which will then be used by HQL
private int id;
private double EmpSalary;

public EmployeeSalaryDetails(){}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getEmpSalary() {
	return EmpSalary;
}

public void setEmpSalary(double salary) {
	this.EmpSalary = salary;
}

}
