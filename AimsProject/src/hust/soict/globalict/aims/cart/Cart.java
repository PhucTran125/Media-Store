package hust.soict.globalict.aims.cart;

import java.util.Random;
import java.util.StringTokenizer;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_ORDERED_ITEM = 20;
	public static int luckyNumber = 100;
//	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(MAX_ORDERED_ITEM);
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	//Add method
	public void addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() < MAX_ORDERED_ITEM) {
			itemsOrdered.add(media);
			System.out.println("Add to Cart successfully!");
		} 
		else {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		}
	}

	//Remove method
	public void removeMedia(Media disc) {
		boolean check = itemsOrdered.remove(disc);
		if (check == true) System.out.println("Removed successfully");
		else System.out.println("There is no such title in store. Try again!");
	}
	public void removeMedia(String title) {
		String check = "There is no such title in store. Try again!";
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).getTitle().equalsIgnoreCase(title) == true) {
				itemsOrdered.remove(i);
				check = "Removed successfully";
			}
		}
		System.out.println(check);
	}
	
	//Remove all disc in cart
	public void removeAll() {
		itemsOrdered.clear();
	}

	// Total cost
	public float totalCost() {
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum = sum + itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	// Sort by cost
	public void sortByCost() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:" + itemsOrdered.size());
		java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		for (Media item: itemsOrdered) {
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
		System.out.println("**************************************************");
	}
	
	// Sort by title
	public void sortByTitle() {
//		for (int i = 0; i < itemsOrdered.size() - 1; i++) {
//			for (int j = i + 1; j < itemsOrdered.size(); j++) {
//				if ((itemsOrdered.get(i).getTitle()).compareTo(itemsOrdered.get(j).getTitle()) > 0) {
//					Media tmp = itemsOrdered.get(i);
//					itemsOrdered.set(i, itemsOrdered.get(j));
//					itemsOrdered.set(j, tmp);
//				}
//			}
//		}
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:" + itemsOrdered.size());
		java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
		for (Media item: itemsOrdered) {
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
		System.out.println("**************************************************");
	}
	
	// Search by ID
	public static String searchById(DigitalVideoDisc[] array, int id) {
		String result = "Not found!";
		for (int i = 0; i < array.length; i++) {
			if(array[i].getId() == id) {
				result = array[i].getId() + ". DVD - [" + array[i].getTitle() + "] - [" + array[i].getCategory() + "] - [" 
						+ array[i].getDirector() + "] - [" + array[i].getLength() + "]: [" + array[i].getCost() + "] $";
				return result;
			}
		}
		return result;
	}
	public String searchById(Integer id) {
		String result = "Not found!";
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getId() == id) {
				System.out.println("The result is:");
				result = itemsOrdered.get(i).getId() + ". DVD - [" + itemsOrdered.get(i).getTitle() + "] - [" + itemsOrdered.get(i).getCategory() +
						"]: [" + itemsOrdered.get(i).getCost() + "] $";
			}
		}
		return result;
	}
	
	//Search by Title
	public String searchByTitle(String title) {
		String result = "Not found!";
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if(itemsOrdered.get(i).getTitle().equalsIgnoreCase(title) == true) {
				System.out.println("The result is:");
				result = itemsOrdered.get(i).getId() + ". DVD - [" + itemsOrdered.get(i).getTitle() + "] - [" + itemsOrdered.get(i).getCategory() +
						"]: [" + itemsOrdered.get(i).getCost() + "] $";
			}
		}
		return result;
	}
	
	// Sort cart
	public void sortCart() {
		for (int i = 0; i < itemsOrdered.size() - 1; i++) {
			for (int j = i + 1; j < itemsOrdered.size(); j++) {
				if (itemsOrdered.get(i).getTitle().compareTo(itemsOrdered.get(j).getTitle()) > 0) {
					Media tmp = itemsOrdered.get(i);
					itemsOrdered.set(i, itemsOrdered.get(j));
					itemsOrdered.set(j, tmp);
				}
				if (itemsOrdered.get(i).getTitle().compareTo(itemsOrdered.get(j).getTitle()) == 0) {
					if (itemsOrdered.get(i).getCost() < itemsOrdered.get(j).getCost()) {
						Media tmp = itemsOrdered.get(i);
						itemsOrdered.set(i, itemsOrdered.get(j));
						itemsOrdered.set(j, tmp);
					}
					if (itemsOrdered.get(i).getCost() == itemsOrdered.get(j).getCost()) {
						if (itemsOrdered.get(i) instanceof DigitalVideoDisc && itemsOrdered.get(j) instanceof DigitalVideoDisc) {
							DigitalVideoDisc disc1 = (DigitalVideoDisc)itemsOrdered.get(i);
							DigitalVideoDisc disc2 = (DigitalVideoDisc)itemsOrdered.get(j);
							if (disc1.getLength() < disc2.getLength()) {
								Media tmp = itemsOrdered.get(i);
								itemsOrdered.set(i, itemsOrdered.get(j));
								itemsOrdered.set(j, tmp);
							}
						}
					}
				}
			}
		}
	}
	
	//Print cart
	public void printCart() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:" + itemsOrdered.size());
		sortCart();
		
		for (Media item: itemsOrdered) {
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
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("**************************************************");
	}
	public void printCart(Media media) {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:" + itemsOrdered.size());
		sortCart();
		
		for (Media item: itemsOrdered) {
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
		System.out.println("The lucky item is: " + media.getTitle() + " and the cost " + media.getCost() + " $.");
		System.out.println("Total cost: " + (totalCost() - media.getCost()) + "$");
		System.out.println("**************************************************");
	}
	
	//search DVDs in cart by title
	public boolean search(String title, String check) {
		StringTokenizer str = new StringTokenizer(title);
		StringTokenizer dvd = new StringTokenizer(check);
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
	public void searchInCart(String title) {
		String result = "No match is found!";
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (search(title, itemsOrdered.get(i).getTitle()) == true) {
				result = "The result is: [" + itemsOrdered.get(i).getTitle() + "] - [" + itemsOrdered.get(i).getCategory() + "] - [" + 
						"]:  [" + itemsOrdered.get(i).getCost() + "] $";
			}
		}
		System.out.println(result);
	}
	
	// Play media
		public void play(String inputPlay) throws PlayerException {
			for (Media item: itemsOrdered) {
				if (item.getTitle() == inputPlay && item instanceof CompactDisc) {
					CompactDisc cd = (CompactDisc) item;
					try {
						cd.play();
					} catch (Exception e) {
						throw e;
					}
				}
				if (item.getTitle() == inputPlay && item instanceof DigitalVideoDisc) {
					DigitalVideoDisc disc = (DigitalVideoDisc) item;
					try {
						disc.play();
					} catch (Exception e) {
						throw e;
					}
				}
			}
		}
	
	// Get a lucky item in cart
	public Media getALuckyItem() {
		if (itemsOrdered.size() > 2) {
			Integer idArray[] = new Integer[itemsOrdered.size()];
			for (int i = 0; i < itemsOrdered.size(); i++) {
				idArray[i] = itemsOrdered.get(i).getId();
			}
			int luckyNum = new Random().nextInt(idArray.length);
			luckyNum = idArray[luckyNum];
			luckyNumber = luckyNum;
			for (Media item: itemsOrdered) {
				if (item.getId() == luckyNum) return item;
			}
			return null;
		}
		else {
			String message = "Cannot get lucky number. Your number of media in cart is not greater than 3!";
			JOptionPane.showMessageDialog(null,
			message,"Error",JOptionPane.INFORMATION_MESSAGE);
			return null;
		}
	}

	public ObservableList<Media> getItemOrdered() {
		sortCart();
		return itemsOrdered;
	}
	
	public ObservableList<Media> getMediaById(String id) {
		ObservableList<Media> list = FXCollections.observableArrayList();
		for(Media item: itemsOrdered) {
			String getID = "" + item.getId();
			if(id.contains(getID)) {
				list.add(item);
			}
		}
		return list;
	}
	
	public ObservableList<Media> getMedia(String title) {
		ObservableList<Media> list = FXCollections.observableArrayList();
		for(Media item: itemsOrdered) {
			if(item.getTitle().contains(title)) {
				list.add(item);
			}
		}
		return list;
	}
}