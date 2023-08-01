package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtil {


	private jdbcUtil() {
		
	}
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws SQLException, IOException {
		FileInputStream fs = new FileInputStream("./src/properties/db.properties");
		Properties properties = new Properties();
		properties.load(fs);
		
		String url = properties.getProperty("url");
		String username= properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url , username , password);
		return connection;
		
	}
	
	

}

	
	