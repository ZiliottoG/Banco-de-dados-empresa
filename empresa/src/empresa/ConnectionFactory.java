package empresa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection;

	private static String driverClass = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_empresa?useTimezone=true&serverTimezone=UTC";
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";
	
	protected static final ThreadLocal<ConnectionFactory> instance = new ThreadLocal<ConnectionFactory>() {
		protected ConnectionFactory initialValue() {
			return new ConnectionFactory();
		}
	};

	private ConnectionFactory() {
			
		try {
			Class.forName(driverClass);
		}
		catch (ClassNotFoundException ex) {
	        	System.out.println("ClassNotFoundException: " + ex.getMessage());
		}

	}

	private Connection createConnection() {

		if (connection == null) { 

			try {
				connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	        }
	        catch (SQLException ex) {
	               	System.out.println("SQLException: " + ex.getMessage());
	        }
		}
		
		return connection;
	}

	public static void closeConnection() {
			
		if (connection != null) {
	    	try { 
	    		connection.close();
				connection = null;
				
	    	} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
	    	}
		}
	}
	        

	public static Connection getConnection() {
		
		return instance.get().createConnection();
	}
