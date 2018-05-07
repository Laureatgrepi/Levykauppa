package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Album;
import models.Artist;

public class AlbumDAO {
	private final ChinookDatabase db;

	public AlbumDAO() {
		db = new ChinookDatabase();
	}

	public Album findAlbum(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("select * from album where AlbumId=?");
			statement.setLong(1, id);
			results = statement.executeQuery();

			if (results.next()) {
				String nimi = results.getString("Title");
				long albumId = results.getLong("AlbumId");
				return new Album(nimi, albumId);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		return null;

	}

	public List<Album> findAlbumByArtistId(Artist a) {
		List<Album> albumsByArtist = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;

		try {
			connection = db.connect();
			statement = connection.prepareStatement("select * from album where ArtistId=?");
			statement.setLong(1, a.getId());
			results = statement.executeQuery();
			
			while (results.next()) {
				String title = results.getString("Title");
				long albumId = results.getLong("AlbumId");
				Album aa = new Album(title, albumId);
				albumsByArtist.add(aa);
				

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		return albumsByArtist;

	}
	
	public List<Album> findAlbumsByTitle(String title){
		
		List<Album> albumsByTitle = new ArrayList<>();

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("select * from album where Title=?");
			statement.setString(1, title);
			results = statement.executeQuery();
			
			while (results.next()) {
				String nimi = results.getString("Title");
				long albumId = results.getLong("AlbumId");
				Album aa = new Album(nimi, albumId);
				albumsByTitle.add(aa);
				

			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		return albumsByTitle;

	}

}