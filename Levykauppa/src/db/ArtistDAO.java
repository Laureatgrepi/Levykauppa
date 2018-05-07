package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.Artist;

public class ArtistDAO {

	private final ChinookDatabase db;

	public ArtistDAO() {
		db = new ChinookDatabase();
	}

	public List<Artist> findAllArtists() {
		List<Artist> allArtists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("select * from artist");
			results = statement.executeQuery();

			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("name");

				Artist a = new Artist(id, name);
				allArtists.add(a);

			}

		} catch (Exception e){
			throw new RuntimeException(e);
		}finally{
			db.closeAll(connection, statement, results);
		}

		return allArtists;
	}

	public Artist findArtist(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("select * from artist where ArtistId=?");
			statement.setLong(1, id);
			results = statement.executeQuery();

			if (results.next()) {
				String nimi = results.getString("Name");
				long artistId = results.getLong("ArtistId");
				return new Artist(artistId, nimi);
			}

		} catch (Exception e){
			throw new RuntimeException(e);
		}finally{
			db.closeAll(connection, statement, results);
		}
		return null;

	}

	public void storeArtist(Artist artist) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("insert into artist (name) values(?)",
													Statement.RETURN_GENERATED_KEYS);
			statement.setString(1,artist.getName());
			statement.executeUpdate();

			results = statement.getGeneratedKeys();
			
			if(results.next()){
				long id = results.getLong(1);
				artist.setId(id);
			}
		

		} catch (Exception e){
			throw new RuntimeException(e);
		}finally{
			db.closeAll(connection, statement, results);
		}
	}

}
