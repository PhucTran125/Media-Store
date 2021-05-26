package hust.soict.global.aims.store;
import java.util.ArrayList;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Store {
	public static final int MAX_NUMBERS_STORE = 30;
	private ArrayList<Media> itemsInStore = new ArrayList<Media>(MAX_NUMBERS_STORE);
	
	//Add to Store
	public void addMedia(DigitalVideoDisc disc) {
		if (itemsInStore.contains(disc) == true) System.out.println("The Cart is already full");
		else {
			itemsInStore.add(disc);
			System.out.println("Added successfully");
		}
	}
	public void addMedia(Book book) {
		if (itemsInStore.contains(book) == true) System.out.println("The Cart is already full");
		else {
			itemsInStore.add(book);
			System.out.println("Added successfully");
		}
	}
	
	public void addMedia(CompactDisc cd) {
		if (itemsInStore.contains(cd) == true) System.out.println("The Cart is already full");
		else {
			itemsInStore.add(cd);
			System.out.println("Added successfully");
		}
	}

	//Remove from store
	public void removeMedia(DigitalVideoDisc disc) {
		String check = "There is no such media in store. Try again!";
		if (itemsInStore.contains(disc) == true) {
			itemsInStore.remove(disc);
			check = "Removed successfully";
		}
		System.out.println(check);
	}
	public void removeMedia(String title) {
		String check = "There is no such title in store. Try again!";
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
				itemsInStore.remove(i);
				check = "Removed successfully";
			}
		}
		System.out.println(check);
	}
	
	public void removeAll() {
		for (int i = 0; i < itemsInStore.size(); i++) {
			itemsInStore.remove(i);
		}
		System.out.println(itemsInStore.size());
	}
	
	//View the store
	public void viewStore() {
		System.out.println("***********************STORE**********************");
		System.out.println("All Items:");
		
		for (int i = 0; i < itemsInStore.size() - 1; i++) {
			for (int j = i + 1; j < itemsInStore.size(); j++) {
				if (itemsInStore.get(i).getTitle().compareTo(itemsInStore.get(j).getTitle()) > 0) {
					Media tmp = itemsInStore.get(i);
					itemsInStore.set(i, itemsInStore.get(j));
					itemsInStore.set(j, tmp);
				}
				if (itemsInStore.get(i).getTitle().compareTo(itemsInStore.get(j).getTitle()) == 0) {
					if (itemsInStore.get(i).getCost() < itemsInStore.get(j).getCost()) {
						Media tmp = itemsInStore.get(i);
						itemsInStore.set(i, itemsInStore.get(j));
						itemsInStore.set(j, tmp);
					}
					if (itemsInStore.get(i).getCost() == itemsInStore.get(j).getCost()) {
						if (itemsInStore.get(i) instanceof DigitalVideoDisc && itemsInStore.get(j) instanceof DigitalVideoDisc) {
							DigitalVideoDisc disc1 = (DigitalVideoDisc)itemsInStore.get(i);
							DigitalVideoDisc disc2 = (DigitalVideoDisc)itemsInStore.get(j);
							if (disc1.getLength() < disc2.getLength()) {
								Media tmp = itemsInStore.get(i);
								itemsInStore.set(i, itemsInStore.get(j));
								itemsInStore.set(j, tmp);
							}
						}
					}
				}
			}
		}
		for (Media item: itemsInStore) {
			if (item instanceof DigitalVideoDisc) {
				DigitalVideoDisc disc = (DigitalVideoDisc)item;
				System.out.println(disc.getId() + ". DVD - [" + disc.getTitle() + "]");
			}
			if (item instanceof Book) {
				Book book = (Book)item;
				System.out.println(book.getId() + ". Book - [" + book.getTitle() + "]");
			}
			if (item instanceof CompactDisc) {
				CompactDisc cd = (CompactDisc)item;
				System.out.println(cd.getId() + ". CD - [" + cd.getTitle() + "]");
			}
		}
		System.out.println("**************************************************");
	}
	//View a DVD's details
	public void viewDetail(Integer id) {
		for (Media item: itemsInStore) {
			if (item instanceof DigitalVideoDisc && item.getId() == id) {
				DigitalVideoDisc disc = (DigitalVideoDisc) item;
				System.out.println(disc.getDetail());
			}
			if (item instanceof Book && item.getId() == id) {
				Book book = (Book) item;
				System.out.println(book.getDetail());
			}
			if (item instanceof CompactDisc && item.getId() == id) {
				CompactDisc cd = (CompactDisc) item;
				System.out.println(cd.getDetail());
			}
		}	
	}
	//Get Media
	public Media getMedia(Integer id) {
		for (Media item: itemsInStore) {
			if (item.getId() == id) {			
				return item;
			} 
		}
		return null;
	}
	public Media getMedia(String title) {
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i).getTitle() == title) {			
				return this.itemsInStore.get(i);
			} 
		}
		return null;
	}
	// Play media
	public void play(String inputPlay) {
		for (Media item: itemsInStore) {
			if (item.getTitle().equalsIgnoreCase(inputPlay) && item instanceof CompactDisc) {
				CompactDisc cd = (CompactDisc) item;
				try {
					cd.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (item.getTitle().equalsIgnoreCase(inputPlay) && item instanceof DigitalVideoDisc) {
				DigitalVideoDisc disc = (DigitalVideoDisc) item;
				try {
					disc.play();
				} catch (PlayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public ArrayList<Media> getItemInStore() {
		// TODO Auto-generated method stub
		return itemsInStore;
	}
}
