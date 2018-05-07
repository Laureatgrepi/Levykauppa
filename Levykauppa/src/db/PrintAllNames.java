package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintAllNames {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ChinookDatabase db = new ChinookDatabase();
		Connection connection = db.connect();
		
		PreparedStatement statement = connection.prepareStatement("select * from artist");
		
		ResultSet results = statement.executeQuery();
		
		while(results.next()){
			String name = results.getString("name");
			System.out.println(name);
		}
		
		results.close();
		statement.close();
		connection.close();
		
	}

}
