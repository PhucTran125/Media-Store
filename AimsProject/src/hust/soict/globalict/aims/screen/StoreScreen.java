package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.global.aims.store.Store;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;


public class StoreScreen extends JFrame {
	protected static Store store = new Store();
	protected static Cart cart = new Cart();
	
	public JMenuBar createMenuBar() {
		ItemActionListener action = new ItemActionListener();
		JMenu menu = new JMenu("Options");
		JMenuItem item = new JMenuItem();
		
		JMenu smUpdateStore = new JMenu("Update Store");
		item = new JMenuItem("Add Book");
		smUpdateStore.add(item);
		item.addActionListener(action);
		item = new JMenuItem("Add CD");
		smUpdateStore.add(item);
		item.addActionListener(action);
		item = new JMenuItem("Add DVD");
		smUpdateStore.add(item);
		item.addActionListener(action);
		
		
		menu.add(smUpdateStore);
		item = new JMenuItem("View Store");
		menu.add(item);
		item.addActionListener(action);
		item = new JMenuItem("View Cart");
		menu.add(item);
		item.addActionListener(action);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	public JPanel createHeader() {
		ItemActionListener action = new ItemActionListener();
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View Cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		cart.addActionListener(action);
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	public JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}
	
	public StoreScreen(Store store) {
		StoreScreen.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
//	//Create a new store
//	public static Store storeList = new Store();
		
	public static void main(String[] args) {
		//DVD already in store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Avengers", "Fiction", "Ben", 2, 15.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Cinderella", "Fairy tale", "Kovacic", 8, 6.2f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Iron man I", "Fiction", "Ben", 1, 15.6f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Jungle", "Legend", "Jame", 5, 3.3f);
//		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Old father", "Mentality", "Tran Thanh", 3, 5f);
		
		Book book1 = new Book("Chelsea", "Chronicle", "Chelsea is a best football club in the world", 50.4f);
		store.addMedia(book1);
		Book book2 = new Book("Sapiens: A Brief History of Humankind", "Non-fiction", "The book covers the evolutionary history of mankind from ancient times in the Stone Age to the twenty-first century, focusing on Homo sapiens.", 20.4f);
		store.addMedia(book2);
		CompactDisc cd1 = new CompactDisc("Chelsea2021", "Sport", "Tuchel", "Mason Mount", 8, 58.8f);
		CompactDisc cd2 = new CompactDisc("HUST", "Learning", "Technology", "Student", 10, 62.2f);
		store.addMedia(cd1);
		store.addMedia(cd2);
		
		DigitalVideoDisc[] listDVD = {dvd1, dvd2, dvd3, dvd4};
		for (int i = 0; i < listDVD.length; i++) {
			store.addMedia(listDVD[i]);
		}
		new StoreScreen(store);
	}
	
	private class ItemActionListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			String button = evt.getActionCommand();
			if (button.equals("Add Book")) {
				AddBookToStoreScreen.main(null);
			} else if (button.equals("Add CD")) {
				AddCompactDiscToStoreScreen.main(null);
			} else if (button.equals("Add DVD")){
				AddDigitalVideoDiscToStoreScreen.main(null);
			} else if (button.equals("View Cart")) {
				new CartScreen(cart);
			} else {
				new StoreScreen(store);
			}
			
		}		
	}
	
	public static Store getStore() {
		return store;
	}
}
