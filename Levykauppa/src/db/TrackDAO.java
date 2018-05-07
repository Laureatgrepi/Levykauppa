package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Album;
import models.Track;

public class TrackDAO {
	
	private final ChinookDatabase db;

	public TrackDAO() {
		db = new ChinookDatabase();
	}


	public List<Track> findTracksByAlbum(Album album){
		List<Track> tracksByAlbum = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("select name,trackid from track t "
					+ "								join album a on a.albumId=t.albumId"
					+ "								 where t.albumid=?");
			statement.setLong(1, album.getAlbumId());
			results = statement.executeQuery();
			
			while (results.next()) {
				String nimi = results.getString("Name");
				long trackId = results.getLong("TrackId");
				Track kappale =  new Track(trackId, nimi);
				tracksByAlbum.add(kappale);
				
			}

		}catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		return tracksByAlbum;

		
	}
}
