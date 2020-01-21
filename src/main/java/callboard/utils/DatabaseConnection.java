package callboard.utils;


import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection
{

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost/callboard";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "admin";

	public static Connection getDBConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName(DB_DRIVER);
			conn = DriverManager.
					getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			System.out.println("Connection Established: " + conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
