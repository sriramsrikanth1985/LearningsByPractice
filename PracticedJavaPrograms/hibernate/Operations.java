package hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Operations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		
		//Inserting a row into the table Emp
		Employee emp = new Employee();
		emp.setEmpId(2);
		emp.setEmpName("SSrikanth");
		emp.setEmpCity("Bangalore");
		emp.setEmpState("Karnataka");
		s.saveOrUpdate(emp);
		
		//Selecting and Updating is done here
		Employee emp1 = (Employee)s.get(Employee.class, emp.getEmpId());
		emp1.setEmpName("SSrikanth Sriram");
		s.saveOrUpdate(emp1);
		/* String hql = "FROM city c where c.id = 2";
		Query query = s.createQuery(hql);
		List list = query.list();*/
		
		//Inserting into other table EmpSalaryDetails
		EmployeeSalaryDetails empsal = new EmployeeSalaryDetails();
		empsal.setId(emp1.getEmpId());
		empsal.setEmpSalary(1234.11);
		s.saveOrUpdate(empsal);
		
		//Deleting is done here
		Employee empdel = new Employee();
		empdel.setEmpId(1);
		s.delete(empdel);

		//Flushing to reflect the changes to DB and commit
		s.flush();
		tx.commit();
	}

}
