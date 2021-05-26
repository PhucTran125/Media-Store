package hust.soict.globalict.test.utils;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils;

public class DVDTest {

	public static void main(String [] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		//compareByCost
		if (DVDUtils.compareByCost(dvd1, dvd2) == 0) {
			System.out.println("Cost of two dvd are equal.");
		}
		else if (DVDUtils.compareByCost(dvd1, dvd2) == 1) {
			System.out.println("Cost of dvd1 is greater than cost of dvd2.");
		}
		else System.out.println("Cost of dvd1 is less than cost of dvd2.");
		//compareByTitle
		System.out.print("Title of two dvds are equal: ");
		System.out.println(DVDUtils.compareByTitle(dvd5, dvd3));
		//sort
		DigitalVideoDisc [] sorted = DVDUtils.sortByCost(new DigitalVideoDisc[] {dvd1, 
				dvd2, dvd3, dvd4, dvd5});
		System.out.println("Sort by cost: ");
		for (int i  = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getDetail());
		}
		sorted = DVDUtils.sortByTitle(new DigitalVideoDisc[] {dvd5, 
				dvd3, dvd4, dvd1, dvd2});
		System.out.println("Sort by title: ");
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i].getDetail());
		}
	}
}
