package db;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import models.Album;
import models.Track;

public class TrackDAOTest {

	private TrackDAO dao = new TrackDAO();


	@Test 
	public void testFindinTrackByNonExistingAlbum(){
		Album a = new Album("adafsfsds", 521345);
		
		List<Track> t =dao.findTracksByAlbum(a);
		assertTrue(t.isEmpty());
	}
	
	@Test
	public void testFindingTrackByAlbum() {
		Album a = new Album("Big Ones",5);
		
		List<Track> t =dao.findTracksByAlbum(a);
		
		assertEquals("Walk On Water",t.get(0).getName());
		
	}
	

}
