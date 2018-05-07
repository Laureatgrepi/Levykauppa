package db;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


public class ChinookDatabase {
		
	private static final String URL = "jdbc:sqlite:M:\\sqlite\\Chinook_Sqlite.sqlite";

	public Connection connect()throws SQLException, ClassNotFoundException{
		Class.forName("org.sqlite.JDBC");
		return DriverManager.getConnection(URL);
	}
	public void closeAll(Connection connection, PreparedStatement statement, ResultSet results ){
		close(results);
		close(statement);
		close(connection);
	}
	public void close(AutoCloseable object){
		if(object !=null){
			try{
				object.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
