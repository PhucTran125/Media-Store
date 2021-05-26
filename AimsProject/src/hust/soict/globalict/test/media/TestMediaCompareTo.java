package hust.soict.globalict.test.media;

import java.util.ArrayList;

import hust.soict.globalict.aims.media.*;

public class TestMediaCompareTo {
	public static void main(String[] args) {
		ArrayList<Media> collection = new ArrayList<Media>();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avengers", "Fiction", "Ben", 2, 15.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Chelsea", "Dhronicle", "Phuc", 10, 28.2f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Cinderella", "Fairy tale", "Kovacic", 8, 6.2f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Irt", "School", "Hust", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Iron man I", "Fiction", "Ben", 1, 15.6f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Jungle", "Legend", "Jame", 5, 3.3f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Masterchef", "Food", "Gordon Ramsey", 9, 6.6f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Old father", "Mentality", "Tran Thanh", 3, 5f);
		
		Book book1 = new Book("Chelsea", "Chronicle", "Chelsea is a best football club in the world", 50.4f);
		CompactDisc cdisc = new CompactDisc("BigBang", "Music", "Top", "GD", 8, 5.6f);
		DigitalVideoDisc[] listDVD = {dvd6, dvd8, dvd5, dvd4, dvd3, dvd1, dvd7, dvd2};
		// Add to arraylist
		for (int i = 0; i < listDVD.length; i++) {
			collection.add(listDVD[i]);
		}
		
		collection.add(book1);
		collection.add(cdisc);
		//Iterate through the arraylist and out put their titles
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("-------------------------------------------");
		System.out.println("The Medias currently in the order are: ");
		
		while (iterator.hasNext()) {
			Media item = (Media)iterator.next();
			System.out.println(item.getTitle() + "-" + item.getCategory());
		}
		
		//Sort base on compareTo
		java.util.Collections.sort((java.util.List)collection);
		
		iterator = collection.iterator();
		System.out.println("-------------------------------------------");
		System.out.println("The Medias in sorted order are: ");
		
		while (iterator.hasNext()) {
			Media item = (Media)iterator.next();
			System.out.println(item.getTitle() + "-" + item.getCategory());
		}
		System.out.println("-------------------------------------------");
		// toString()
		// i had already finished this exercise with getDetail() function
		System.out.println("Here is detail of all media:");
		for (Media item: collection) {
			if (item instanceof DigitalVideoDisc) {
				DigitalVideoDisc disc = (DigitalVideoDisc) item;
				System.out.println(disc.getDetail());
			}
			if (item instanceof Book) {
				Book book = (Book) item;
				System.out.println(book.getDetail());
			}
			if (item instanceof CompactDisc) {
				CompactDisc cd = (CompactDisc) item;
				System.out.println(cd.getDetail());
			}
		}
	}
}
