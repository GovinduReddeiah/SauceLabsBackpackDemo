package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnection {
	
	public static Connection connection;
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		Properties prop = new Properties();
		prop.load(new FileInputStream("src\\main\\java\\config\\config.properties"));
		String url = prop.getProperty("db.url");
        String user = prop.getProperty("db.user");
        String password = prop.getProperty("db.password");
		connection = DriverManager.getConnection(url, user, password);
		return connection;
	}
	
	public static ResultSet  executeQuery(String query) throws FileNotFoundException, SQLException, IOException {
		Statement stmnt = getConnection().createStatement();
		return stmnt.executeQuery(query);
	}
	
	public void CloseConnection() throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}

}
