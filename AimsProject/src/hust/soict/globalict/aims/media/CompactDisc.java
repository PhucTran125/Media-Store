package hust.soict.globalict.aims.media;
import java.util.ArrayList;

import hust.soict.globalict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	
	// Constructor
	public CompactDisc(String title, String category, String director, String artist, int length, float cost) {
		super(title, category, director, length, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track inputTrack) {
		boolean check = true;
		for (Track item: tracks) {
			if (item.getTitle().equalsIgnoreCase(inputTrack.getTitle()) == true && item.getLength() == inputTrack.getLength()) {
				System.out.println("This track is already in the list of track.");
				check = false;
			}
		}
		if (check = true) tracks.add(inputTrack);
	}
	public void removeTrack(Track inputTrack) {
		String check = "This track is not exist in the list of track.";
		for (Track item: tracks) {
			if (item == inputTrack) {
				tracks.remove(inputTrack);
				check = "Remove successfully";
			}
		}
		System.out.println(check);
	}
	public int getLength() {
		int totalLength = 0;
		for (Track item: tracks) {
			totalLength += item.getLength();
		}
		return totalLength;
	}
	
	//getDetail()
		public String getDetail() {
			String result = getId() + ".CD - [" + getTitle() + "] - [" + getCategory() + "] - [" + getDirector() +
					"] - [" + getArtist() + "] - [" + getLength() + "]: [" + getCost() + "] $. This CD have " + tracks.size() + "track(s).";
			for (int i = 0; i < tracks.size(); i++) {
				result += "\nTrack" + (i + 1) + "Title: " + tracks.get(i).getTitle() + ", length is " + tracks.get(i).getLength();
			}
			return result;
		}
	
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing CD: " + this.getTitle());
			System.out.println("CD length: " + this.getLength());
			System.out.println("---This CD have " + tracks.size() + "track(s)---");
			java.util.Iterator iter = tracks.iterator();
			Track nexTrack;
			while (iter.hasNext()) {
				nexTrack = (Track) iter.next();
				try {
					nexTrack.play();
				} catch(PlayerException e) {
					throw e;
				}
			}
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
		
		int i = 0;
		for (Track item: tracks) {
			System.out.println(i++);
			System.out.println("Playing track: " + item.getTitle());
			System.out.println("Track length: " + item.getLength());
		}
	}
}
