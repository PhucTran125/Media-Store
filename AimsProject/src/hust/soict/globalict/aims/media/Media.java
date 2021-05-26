package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Media implements Comparable<Media> {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbMedia = 0;
	protected LocalDate dateAdded;
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public static int getNbMedia() {
		return nbMedia;
	}
	public LocalDate getDateAdded() {
		return dateAdded;
	}
	
	// Constructor
	public Media(String title) {
		super();
		this.title = title;
		this.id = nbMedia++;
	}
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		this.id = nbMedia++;
	}
	
	public String getDetail() {
		return null;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media obj = (Media) o;
			return (this.compareTo(obj) == 0);
		}
		else {
			return false;
		}
	}
	
	public int compareTo(Media item) {
		if (this.getTitle().compareToIgnoreCase(item.getTitle()) != 0) return this.getTitle().compareToIgnoreCase(item.getTitle());
		else {
			if (this.getCost() > item.getCost()) {
				return 1;
			} else if (this.getCost() > item.getCost()) return -1;
			else return 0;
		}
	}
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByCostTitle();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByTitleCost();
}
