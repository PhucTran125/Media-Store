package hust.soict.globalict.aims.media;

public class Disc extends Media {
	private String director;
	private int length;
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	// Constructor
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	// Method
//	@Override
//	public String getDetail() {
//		
//		return super.getDetail();
//	}
}
