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

import javax.naming.LimitExceededException;
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
import hust.soict.globalict.aims.media.Media;

public class AddItemToStoreScreen extends JFrame {
	public JMenuBar createMenuBar() {
		AddMediaListener addMediaListener = new AddMediaListener();
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBookOption = new JMenuItem("Add Book");
		JMenuItem addCDOption = new JMenuItem("Add CD");
		JMenuItem addDVDOption = new JMenuItem("Add DVD");
		addBookOption.addActionListener(addMediaListener);
		addCDOption.addActionListener(addMediaListener);
		addDVDOption.addActionListener(addMediaListener);
		smUpdateStore.add(addBookOption);
		smUpdateStore.add(addCDOption);
		smUpdateStore.add(addDVDOption);
		
		menu.add(smUpdateStore);
		JMenuItem menuItem = new JMenuItem("View store");
		menuItem.addActionListener(addMediaListener);
		menu.add(menuItem);
		menuItem.addActionListener(addMediaListener);
		JMenuItem menuItem_1 = new JMenuItem("View cart");
		menuItem_1.addActionListener(addMediaListener);
		menu.add(menuItem_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	public JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
//		north.add(createHeader());
		return north;
	}
	
	public JPanel createCenter() {
		return null;
	}
	
	private class AddMediaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String option = e.getActionCommand();
			if (option.equals("Add Book")) {
				new AddBookToStoreScreen();
			} else if (option.equals("Add CD")) {
				new AddCompactDiscToStoreScreen();
			} else if (option.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen();
			} else if (option.equals("View store")) {
				new StoreScreen(StoreScreen.store);
			} else if (option.equals("View cart")){
				System.out.println("hello");
				try {
					CartScreen.main(null);
				} catch (LimitExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}
