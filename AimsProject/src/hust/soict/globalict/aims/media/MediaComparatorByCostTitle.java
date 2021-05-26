package hust.soict.globalict.aims.media;
import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
	public int compare(Media o1, Media o2) {
		if (o1.getCost() > o2.getCost()) return 1;
		else if (o1.getCost() < o2.getCost()) return -1;
		else {
			if (o1.getTitle().compareToIgnoreCase(o2.getTitle()) != 0) return o1.getTitle().compareToIgnoreCase(o2.getTitle());
			else return 0;
		}
	}
	Comparator<Media> compareByCostTitle = Comparator.comparing(Media::getCost).thenComparing(Media::getTitle);
}
