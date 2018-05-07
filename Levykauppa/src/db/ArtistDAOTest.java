package db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;
import models.Artist;

public class ArtistDAOTest {

	private ArtistDAO dao = new ArtistDAO();

	@Test
	public void testFirstArtist()  {
		List<Artist> artists = dao.findAllArtists();

		Artist first = artists.get(0);

		assertEquals("AC/DC", first.getName());
	}

	@Test
	public void testSecondArtist()  {
		List<Artist> artists = dao.findAllArtists();

		Artist second = artists.get(1);
		assertEquals("Accept", second.getName());
	}
	
	@Test
	public void testFindingArtistById(){
		Artist a = dao.findArtist(50);
		
		assertNotNull(a);
		assertEquals("Metallica", a.getName());
	}
	@Test
	public void testFindingArtistWithNonExistingId(){
		Artist a = dao.findArtist(1234567);
		
		assertEquals(null, a);
	}
	@Test
	public void sdfd(){
		Artist a = new Artist("Alma");
		dao.storeArtist(a);
		
		assertTrue(0<a.getId());
	}
	

}
