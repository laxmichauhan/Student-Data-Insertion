package db;
import java.sql.Connection;
import java.sql.DriverManager;
public class Dconnect {


public static class Connect {
	private static Connection con;
	
	public static Connection dbcon()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myweb","root","root");
			//System.out.println("Connection Ready"+con);
		}
		catch(Exception e) {
			System.out.println("Connection Exception"+e);
		}
		return con;
		}
}


}
