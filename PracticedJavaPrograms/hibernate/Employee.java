package hibernate;

import java.io.Serializable;

public class Employee implements Serializable {

//All the table columns mapping to corresponding type variable, which will then be used by HQL
private int EmpId;
private String EmpName;
private String EmpCity;
private String EmpState;

public Employee(){}

public int getEmpId() {
	return EmpId;
}

public void setEmpId(int empId) {
	EmpId = empId;
}

public String getEmpName() {
	return EmpName;
}

public void setEmpName(String empName) {
	EmpName = empName;
}

public String getEmpCity() {
	return EmpCity;
}

public void setEmpCity(String empCity) {
	EmpCity = empCity;
}

public String getEmpState() {
	return EmpState;
}

public void setEmpState(String empState) {
	EmpState = empState;
}


}
