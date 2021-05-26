package hust.soict.globalict.test.media;

import java.util.ArrayList;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.Media;

public class BookTest {
	public static void main(String[] args) {
		ArrayList<Media> collection = new ArrayList<Media>();
		Book book1 = new Book("Conan", "Mystery", "Conan is a good comic", 7.6f);
		Book book2 = new Book("Doraemon", "Fictional", "A robot cat come from future to help Nobita and he is a wonderfull robot", 6.9f);
		Book book3 = new Book("Soict", "School", "The best school in VietNam about technology and good school for studying", 10.5f);
		
		collection.add(book1);
		collection.add(book2);
		collection.add(book3);
		
		for (Media item: collection) {
			System.out.println(item.getDetail());
		}
	}
}
