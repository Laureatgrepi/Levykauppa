package models;

public class Artist {
	private long id;
	private String name;
	
	public Artist(long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Artist(long id) {
		this.id=id;
	}

	public Artist(String name) {
		this.name=name;
	}
	public Artist(){
		
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
