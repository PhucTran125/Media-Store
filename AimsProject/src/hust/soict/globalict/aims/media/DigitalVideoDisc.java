package hust.soict.globalict.aims.media;

import java.util.StringTokenizer;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

	//Create constructor
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	// Method
	public void play() throws PlayerException {
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}
	//getDetail()
	public String getDetail() {
		String result = getId() + ".DVD - [" + getTitle() + "] - [" + getCategory() + "] - [" + getDirector() + "] - [" 
				+ getLength() + "]: [" + getCost() + "] $";
		return result;
	}
	public boolean search(String title) {
		StringTokenizer str = new StringTokenizer(title);
		StringTokenizer dvd = new StringTokenizer(getTitle());
		int countTokenStr = str.countTokens();
		int countTokenDvd = dvd.countTokens();
		String arrTokenStr[] = new String[countTokenStr];
		String arrTokenDvd[] = new String[countTokenDvd];
		for (int i = 0; i < countTokenStr; i++) {
			arrTokenStr[i] = str.nextToken();
		}
		for (int i = 0; i < countTokenDvd; i++) {
			arrTokenDvd[i] = dvd.nextToken();
		}
		for (int i = 0; i < countTokenStr; i++) {
			for (int j = 0; j < countTokenDvd; j++) {
				if (arrTokenDvd[j].equalsIgnoreCase(arrTokenStr[i])) return true;
			}
		}
		return false;
	}
}
