package db;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import models.Album;
import models.Artist;

public class AlbumDAOTest {
	
	private AlbumDAO dao = new AlbumDAO();
	
	@Test
	public void testFindingAlbumById(){
		Album a = dao.findAlbum(5);
		
		assertNotNull(a);
		assertEquals("Big Ones", a.getTitle());
	}
	
	@Test
	public void testFindingAlbumtWithNonExistingId(){
		Album a = dao.findAlbum(1234567);
		
		assertEquals(null, a);
	}
	@Test
	public void testFindingAlbumsByArtistId(){
		Artist a = new Artist(2);
		
		List<Album> lista = dao.findAlbumByArtistId(a);
		assertEquals("Balls to the Wall", lista.get(0).getTitle());
		
	}
	@Test
	public void testFindingAlbumsByNonExistingArtistId(){
		Artist a = new Artist(123456);
		
		List<Album> lista = dao.findAlbumByArtistId(a);
		assertTrue(lista.isEmpty());
	}
	@Test
	public void testFindingAlbumsByTitle(){
		Album a = new Album("Balls to the Wall");
		List<Album> lista = dao.findAlbumsByTitle(a.getTitle());
		
		assertEquals("Balls to the Wall",lista.get(0).getTitle());
		
		
	}



}
