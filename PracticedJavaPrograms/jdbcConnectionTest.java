import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcConnectionTest {
	public static void main (String args[]){
		try {
			//DriverManager.getConnection ("jdbc:oracle:oci8:@", "scott", "tiger");
			//Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@(description=(address=(host=10.71.8.7)(protocol=tcp)(port=1521))(connect_data=(sid=RIMO)))", "ssriram_edb", "ssriram_edb");
			//Connection conn = DriverManager.getConnection ("jdbc:oracle:thin:@blrotedb01:1521:RIMO", "ssriram_adv", "ssriram_adv");
			Connection conn = DriverManager.getConnection ("jdbc:mysql://localhost:3306/test", "root", "root");
			if(conn != null) {
				System.out.println("connection Succesful");
				Statement stmt = conn.createStatement ();
				//stmt.executeQuery("use test");
				//ResultSet rset = stmt.executeQuery ("select table_name from user_tables");
				ResultSet rset = stmt.executeQuery ("show tables");
				 while (rset.next ())
				      System.out.println (rset.getString (1));
			} else
				System.out.println("connection not successfull");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
