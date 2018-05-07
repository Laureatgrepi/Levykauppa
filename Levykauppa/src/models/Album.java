package models;

public class Album {

	private String title;
	private long albumId;
	
	public Album(String title, long albumId) {
		this.title = title;
		this.albumId = albumId;
	}
	

	public Album(long albumId) {
		this.albumId = albumId;
	}


	public Album(String title) {
		super();
		this.title = title;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}
	
	
	
}
