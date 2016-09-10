package intellipaat;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Properties;


/**
 * 
 * @author ssriram
 * Types of Drivers: Drivers are the way of communicating to the database
 * 1. JDBC-ODBC type (slow, used if there is no JDBC to a database)
 * 2. Native API/Client API
 * 3. JDBC to middleware vendors protocol
 * 4. Direct JDBC (fastest and most preferred way)
 */

public class JDBCExample {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	public static void main(String[] args) {
		/**
		 *1. load the jdbc driver
		 *2. crate a connection
		 *3. create a statement
		 *4. execute query and get restultSet
		 *5. close the connection 
		 */
		
		
		/**
		 * Three types of Statements:
		 * 1. Statement (for CURD operations and executes individually, for each execute it will compile, validate and executes)
		 * 2. PreparedStatement (Used to imporve performance, it compile and parse only once, and can execute many times. 
		 * 		Hence very useful in case of very frequent execution of same sql statement)
		 * 3. CallableStatement (used to call procedures and functions)
		 */
		

		try {
			
			Properties prop = new Properties();
			prop.load(new FileInputStream("C:\\Ddrive\\Eclipse_Workspace\\testing\\src\\intellipaat\\DB.properties"));
			String DriverName = prop.getProperty("JDBCDriver");
			String JDBCUrl = prop.getProperty("sid");
			String username = prop.getProperty("user");
			String password = prop.getProperty("password");
			
	/*		System.out.println("DriverName: "+DriverName);
			System.out.println("JDBCUrl: "+JDBCUrl);
			System.out.println("username: "+username);
			System.out.println("password: "+password);*/
			
			Class.forName(DriverName);
			con = DriverManager.getConnection(JDBCUrl,username,password);
			
			//Simple Statement usage
			//simpleStatemenUsage();
			
			//PreparedSatement usage
			//preparedStatementUsage();			
			
			//CallableStatement usage
			System.out.println("Calling callable statement");
			callableStatementUsage();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void simpleStatemenUsage(){
		try{
			stmt = con.createStatement();
			rs = stmt.executeQuery("show tables");
			boolean tableExist = false;
			for(int i=0;rs.next();i++){
				String tableName = rs.getString(1);
				System.out.println("The entry at index: "+i+" is: "+tableName);
				if(tableName.equalsIgnoreCase("Employee"))
					tableExist = true;
			}
	/*			if(!tableExist){
				stmt.execute("create table Employee (EmpId integer, EmpName varchar(100), EmpDept varchar(100));" );
				//System.out.println("rs status: "+rs);
			}*/
		}catch(Exception e){
			e.printStackTrace();
		} 
	}

	public static void preparedStatementUsage(){
		try{
			String insertQuery = "insert into employee (EmpId,EmpName,EmpDept) VALUES (?,?,?);";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			
			for(int i=0;i<10;i++){
				ps.setInt(1, i);
				ps.setString(2, "EmpName"+i);
				ps.setString(3, "EmpDept"+i);
				ps.execute();
			}
			
			System.out.println("inserted successfully and table contents are ....");
			
			rs = stmt.executeQuery("select * from employee");
			for(int i=0;rs.next();i++){
				System.out.println("Row "+i+" : EmpId: "+rs.getInt(1)+" EmpName: "+rs.getString(2)+" EmpDept: "+rs.getString(3));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void callableStatementUsage(){
		try {
			/**
			 * A stored procedure is a segment of declarative SQL statements stored inside the database catalog. 
			 * A stored procedure can be invoked by triggers, other stored procedures, and applications such as Java, Python, PHP, etc.
			 * 
			 * A stored procedure that calls itself is known as a recursive stored procedure. 
			 * Most database management systems support recursive stored procedures. However, MySQL does not support it very well.
			 * 
			 * Advantages:
			 * 1. Typically stored procedures help increase the performance of the applications. Once created, stored procedures are compiled and stored in the database.
			 * 2. Stored procedures help reduce the traffic between application and database server because instead of sending multiple lengthy SQL statements, 
			 * 	the application has to send only name and parameters of the stored procedure.
			 * 3. Stored procedures are reusable and transparent to any applications and are secure.
			 * 
			 * DisAdvantages:
			 * 1. If you use a lot of stored procedures, the memory usage of every connection that is using those stored procedures will increase substantially. 
			 * 2. Constructs of stored procedures make it more difficult to develop stored procedures that have complicated business logic.
			 * 3. It is difficult to debug stored procedures.
			 * 4. It is not easy to develop and maintain stored procedures.
			 */
			
			/**
			 * CREATE DEFINER=`root`@`localhost` PROCEDURE `selectFromEmpTable`()
				BEGIN
					select * from srikanth.employee;
				END
			 */
			
			/**
			 * CREATE DEFINER=`root`@`localhost` PROCEDURE `selectFromEmpTableWithId`(in id INT)
				BEGIN
					select * from srikanth.employee where EmpId=id;
				END
			 */
				callProcedureExample();
				
				
			/**
			 * A stored function is a special kind stored program that returns a single value.
			 * Different from a stored procedure, you can use a stored function in SQL statements wherever an expression is used.
			 * 
			 * Notice that a stored function returns a single value only. If you include a SELECT statement without the INTO clause, you will get an error.
			 */
				
			/**
			 * CREATE DEFINER=`root`@`localhost` FUNCTION `GetCustomerCategory`(creditLimit INT) RETURNS varchar(20) CHARSET latin1
				BEGIN
					DECLARE retVal VARCHAR(20);
    				
    				IF creditLimit > 50000 THEN
						SET retVal="Platinium";
					ELSEIF creditLimit > 30000 AND creditLimit <=50000 THEN
						SET retVal="Gold";
					ELSEIF creditLimit >0 AND creditLimit<=30000 THEN
						SET retVal="Silver";
					ELSE
						SET retVal="UnDefined";
					END IF;
				RETURN (retVal);
			END
			 */
				callFunctionExample();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void callProcedureExample() throws SQLException {
		CallableStatement cs = con.prepareCall("call helloworld()");
		rs = cs.executeQuery();
		
		for(int i=0;rs.next();i++){
			System.out.println("From storedProcedure: "+rs.getString(1));
		}
		
/*			CallableStatement cs = con.prepareCall("call selectFromEmpTable()");
		rs = cs.executeQuery();
		
		for(int i=0;rs.next();i++){
			System.out.println("Row "+i+" : EmpId: "+rs.getInt(1)+" EmpName: "+rs.getString(2)+" EmpDept: "+rs.getString(3));
		}*/
		
/*			CallableStatement cs = con.prepareCall("call selectFromEmpTableWithId(?)");
		cs.setInt(1, 1);
		rs = cs.executeQuery();
		
		for(int i=0;rs.next();i++){
			System.out.println("Row "+i+" : EmpId: "+rs.getInt(1)+" EmpName: "+rs.getString(2)+" EmpDept: "+rs.getString(3));
		}*/
	}

	public static void callFunctionExample()throws SQLException{
		
		CallableStatement cs = con.prepareCall("{? = call GetCustomerCategory(?)}");
		cs.setInt(2, -200);
		cs.registerOutParameter(1, Types.VARCHAR);
		rs = cs.executeQuery();
		for(int i=0;rs.next();i++){
			System.out.println("From storedFunction: "+rs.getString(1));
		}
	}
}
