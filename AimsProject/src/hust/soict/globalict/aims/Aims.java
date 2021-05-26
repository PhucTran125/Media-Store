package hust.soict.globalict.aims;
import java.util.Scanner;

import javax.naming.LimitExceededException;

import hust.soict.global.aims.store.Store;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class Aims {
	//Create a new store
	public static Store storeList = new Store();
	//Create a new cart
	public static Cart anOrderCart = new Cart();
	public static void main(String[] args) throws PlayerException, LimitExceededException {
		//DVD already in store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avengers", "Fiction", "Ben", 2, 15.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Chelsea", "Chronicle", "Phuc", 10, 28.2f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Cinderella", "Fairy tale", "Kovacic", 8, 6.2f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("ICT", "School", "Hust", 4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Iron man I", "Fiction", "Ben", 1, 15.6f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Jungle", "Legend", "Jame", 5, 3.3f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Masterchef", "Food", "Gordon Ramsey", 9, 6.6f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Old father", "Mentality", "Tran Thanh", 3, 5f);
		
		Book book1 = new Book("Chelsea", "Chronicle", "Chelsea is a best football club in the world", 50.4f);
		storeList.addMedia(book1);
		
		CompactDisc cd1 = new CompactDisc("Chelsea2021", "Sport", "Tuchel", "Mason Mount", 8, 58.8f);
		CompactDisc cd2 = new CompactDisc("HUST", "Learning", "Technology", "Student", 10, 62.2f);
		storeList.addMedia(cd1);
		storeList.addMedia(cd2);
		
		DigitalVideoDisc[] listDVD = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7, dvd8};
		for (int i = 0; i < listDVD.length; i++) {
			storeList.addMedia(listDVD[i]);
		}
		boolean check = true;
		do {
			showMenu();
			Scanner keyboard = new Scanner(System.in);
			Integer inputInt = keyboard.nextInt();
			switch (inputInt) {
			case 1:
				viewStore(keyboard);
				break;
			case 2:
				updateStore(keyboard);
				break;
			case 3:
				seeCurCart(keyboard);
				break;
			case 0:
				check = false;
				break;
			default:
				System.out.println("Invalid input! Please choose again.");
				break;
			}
		} while (check);
		MemoryDaemon memoryDaemon = new MemoryDaemon();
		Thread thread = new Thread(memoryDaemon);
		thread.setDaemon(true);
		thread.start();
		memoryDaemon.run();
		System.exit(0);
	}
	//All menu
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. See current cart");
		System.out.println("4. Play a media");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Get a lucky item from cart");
		System.out.println("6. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
	//Function 1
	public static void viewStore(Scanner keyboard) throws LimitExceededException{
		boolean check = true;
		do {
			storeList.viewStore();
			storeMenu();
			Integer inputInt = keyboard.nextInt();
			switch (inputInt) {
			case 1:
				System.out.println("Which Media you want to see the detail? (Please choose an ID)");
				Integer input1 = keyboard.nextInt();
				storeList.viewDetail(input1);
				System.out.println("Would you like to add that Media to the curent cart? Input 1 or 2. (1-Yes/2-No)");
				Integer input2 = keyboard.nextInt();
				if (input2 == 1) {
					try {
						anOrderCart.addMedia(storeList.getMedia(input1));
					} catch (Exception e) {
						throw e;
					}
					System.out.println("Added successfully");
				}
				break;
			case 2:
				System.out.println("What is Media's ID that you would like to add?");
				Integer input3 = keyboard.nextInt();
				anOrderCart.addMedia(storeList.getMedia(input3));
				System.out.println("Added successfully");
				break;
			case 3:
				anOrderCart.printCart();
				break;
			case 4:
				System.out.println("Enter the media's title that you want to play: ");
				String inputPlay = keyboard.nextLine();
				inputPlay = keyboard.nextLine();
				storeList.play(inputPlay);
				break;
			case 0:
				check = false;
				break;
			default:
				System.out.println("Invalid input! Please choose again.");
				break;
			}
		} while (check);
	}
	//Function 2
	public static void updateStore(Scanner keyboard) {
		boolean check = true;
		do {
			System.out.println("Which option do you want to update the store? (1-Add; 2-Remove; 0-Exit)");
			Integer inputInt = keyboard.nextInt();
			switch (inputInt) {
			case 1:
				System.out.println("Add DVD or Book? (1-DVD; 2-Book)");
				Integer choose = keyboard.nextInt();
				if (choose == 1) {
					System.out.println("Input the infomation of DVD that you want to add:");
					System.out.println("Enter the title: ");
					String title = keyboard.nextLine();
					title = keyboard.nextLine();
					System.out.println("Enter the category: ");
					String category = keyboard.nextLine();
					System.out.println("Enter the director: ");
					String director = keyboard.nextLine();
					System.out.println("Enter the length: ");
					String length = keyboard.nextLine();
					Integer lengthInt = Integer.parseInt(length);
					System.out.println("Enter the cost: ");
					String cost = keyboard.nextLine();
					Float costFl = Float.parseFloat(cost);
					DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, lengthInt, costFl);
					storeList.addMedia(dvd);
				}
				else {
					System.out.println("Input the infomation of Book that you want to add:");
					System.out.println("Enter the title: ");
					String title = keyboard.nextLine();
					title = keyboard.nextLine();
					System.out.println("Enter the category: ");
					String category = keyboard.nextLine();
					System.out.println("Enter the content length: ");
					String contentLength = keyboard.nextLine();
					System.out.println("Enter the cost: ");
					String cost = keyboard.nextLine();
					Float costFl = Float.parseFloat(cost);
					Book book = new Book(title, category, contentLength, costFl);
					storeList.addMedia(book);
				}
				
				break;
			case 2:
				storeList.viewStore();
				System.out.println("Enter the title of the media which you wan to remove: ");
				String input2 = keyboard.nextLine().trim();
				input2 = keyboard.nextLine().trim();		
				storeList.removeMedia(input2);
				break;
			case 0:
				check = false;
				break;
			default:
				System.out.println("Invalid input! Please choose again.");
				break;
			}
		} while (check);
	}
	//Function 3
	public static void seeCurCart(Scanner keyboard) throws PlayerException {
		boolean check = true;
		do {
			anOrderCart.printCart();
			cartMenu();
			Integer inputInt = keyboard.nextInt();
			switch (inputInt) {
			case 1:
				System.out.println("Filter by ID of Title: (1-ID; 2-Title)");
				Integer input = keyboard.nextInt();
				if (input == 1) {
					System.out.println("Enter ID: ");
					input = keyboard.nextInt();
					System.out.println(anOrderCart.searchById(input));
				}
				else if (input == 2) {
					System.out.println("Enter Title: ");
					String inputStr = keyboard.nextLine();
					inputStr = keyboard.nextLine();
					System.out.println(anOrderCart.searchByTitle(inputStr));
				}
				else System.out.println("Invalid input! Please choose again.");
				break;
			case 2:
				System.out.println("Sort by Title or Cost: (1-Title; 2-Cost)");
				input = keyboard.nextInt();
				if (input == 1) {
					System.out.println("Your cart is sorted by title: ");
					anOrderCart.sortByTitle();
				}
				else if (input == 2) {
					System.out.println("Your cart is sorted by cost: ");
					anOrderCart.sortByCost();
				}
				else System.out.println("Invalid input! Please choose again.");
				break;
			case 3:
				System.out.println("Enter the media's title that you want to remove from cart: ");
				String input3 = keyboard.nextLine();
				input3 = keyboard.nextLine();
				anOrderCart.removeMedia(input3);
				break;
			case 4: 
				System.out.println("Enter the media's title in your cart that you want to play: ");
				String inputPlay = keyboard.nextLine();
				try {
					anOrderCart.play(inputPlay);
				} catch (Exception e) {
					throw e;
				}
				
				break;
			case 5:
				Media item = (Media)anOrderCart.getALuckyItem();
				anOrderCart.printCart(item);
				break;
			case 6:
				System.out.println("An order is created. Total cost is: " + anOrderCart.totalCost() + "$.");
				anOrderCart.removeAll();
				break;
			case 0:
			check = false;
			break;
			default:
				System.out.println("Invalid input! Please choose again.");
				break;
			}
		} while (check);
	}
}
