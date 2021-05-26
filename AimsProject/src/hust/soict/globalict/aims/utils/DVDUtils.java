package hust.soict.globalict.aims.utils;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DVDUtils {
	public static int compareByCost(DigitalVideoDisc d1, DigitalVideoDisc d2) {
		if (d1.getCost() == d2.getCost()) {
			return 0;
		}
		else if (d1.getCost() > d2.getCost()) {
			return 1;
		}
		else return -1;
	}
	public static boolean compareByTitle(DigitalVideoDisc d1, DigitalVideoDisc d2) {
		return(d1.getTitle().equals(d2.getTitle()));
	}
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].getCost() < array[j].getCost()) {
					DigitalVideoDisc tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		return array;
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i].getTitle().compareTo(array[j].getTitle()) > 0) {
					DigitalVideoDisc tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		return array;
	}
}
