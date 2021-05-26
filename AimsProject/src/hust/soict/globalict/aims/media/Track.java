package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable {
	private String title;
	private Integer length;
	
	public String getTitle() {
		return title;
	}
	public Integer getLength() {
		return length;
	}
	
	// Constructor
	public Track(String title, Integer length) {
		super();
		this.title = title;
		this.length = length;
	}
	
	// Method
	public void play() throws PlayerException {
		int i = 1;
		if (this.getLength() > 0) {
			System.out.println(i);
			System.out.println("\nPlaying track: " + this.getTitle());
			System.out.println("\nTrack length: " + this.getLength());
			i++;
		} else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track obj = (Track)o;
			return (obj.getTitle().equalsIgnoreCase(this.title) && obj.getLength() == this.length);
		}
		else {
			return false;
		}
	}
}
