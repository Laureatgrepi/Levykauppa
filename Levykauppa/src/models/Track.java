package models;

public class Track {

	private long trackId;
	private String name;
	private long mediaTypeId;
	private long genreId;
	private String composer;
	private int bytes;
	private int unitPrice;
	
	public Track(long trackId, String name) {
		this.trackId = trackId;
		this.name = name;
	}

	public Track(long trackId) {
		this.trackId = trackId;
	}

	public Track(String name) {
		super();
		this.name = name;
	}

	public long getTrackId() {
		return trackId;
	}

	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMediaTypeId() {
		return mediaTypeId;
	}

	public void setMediaTypeId(long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}
	
	 
	
	
}
