package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderValidationInDB {

	
	public void validateOrderInDB(String customerName) throws FileNotFoundException, SQLException, IOException {
		int reTries = 3;
		boolean orderFound = false;
		while(reTries > 0) {
			ResultSet rs = DBConnection.executeQuery(
					"SELECT * FROM orders WHERE customer='"+customerName+"' ORDER BY created_at DESC"
					);
			if(rs.next()) {
				System.out.println("Order Found!!");
				orderFound = true;
				break;
			}
			reTries--;
		}
		
		if(!orderFound) {
			System.out.println("Order not Found!!");	
		}
		
	}
}
