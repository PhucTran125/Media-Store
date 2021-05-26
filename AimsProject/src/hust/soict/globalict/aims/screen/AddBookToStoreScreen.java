package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	public  JPanel center;
	private JTextField titleField;
	private JTextField categoryField;
	private JTextField contentField;
	private JTextField costField;
	
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setBounds(100, 100, 631, 430);
		center.setLayout(null);
		
		JLabel label = new JLabel();
		
		label = new JLabel("Enter Book data");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("UTM Avo", Font.BOLD, 22));
		label.setBounds(193, 30, 191, 66);
		center.add(label);
		
		label = new JLabel("Title:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 106, 79, 32);
		center.add(label);
		
		
		titleField = new JTextField();
		titleField.setBounds(193, 106, 333, 32);
		center.add(titleField);
		titleField.setColumns(10);
		
		label = new JLabel("Category:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 148, 79, 32);
		center.add(label);
		
		categoryField = new JTextField();
		categoryField.setColumns(10);
		categoryField.setBounds(193, 148, 333, 32);
		center.add(categoryField);
		
		label = new JLabel("Content:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 190, 79, 32);
		center.add(label);
		
		contentField = new JTextField();
		contentField.setColumns(10);
		contentField.setBounds(193, 190, 333, 32);
		center.add(contentField);
		
		label = new JLabel("Cost:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 232, 79, 32);
		center.add(label);
		
		costField = new JTextField();
		costField.setColumns(10);
		costField.setBounds(193, 232, 333, 32);
		center.add(costField);
		
		JButton btnNewButton = new JButton("ADD TO STORE");
		btnNewButton.setFont(new Font("UTM Avo", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleField.getText().trim();
				String category = categoryField.getText().trim();
				String content = contentField.getText().trim();
				String cost = costField.getText().trim();
				Float costfl = Float.parseFloat(cost);
				if (title.equals("") || category.equals("") || content.equals("") || cost.equals("")) {
					return;
				}
				Book newBook = new Book(title, category, content, costfl);
				StoreScreen.store.addMedia(newBook);
				// successfully
				JFrame f = new JFrame();
		        JDialog d = new JDialog(f , "Adding successfully!!!", true);  
		        d.setLayout(new FlowLayout());  
		        JButton b = new JButton ("Confirm");  
		        b.addActionListener ( new ActionListener()  
		        {  
		            public void actionPerformed( ActionEvent e )  
		            {  
		                d.setVisible(false);  
		            }  
		        });
		        d.add(b);   
		        d.setSize(300,150);    
		        d.setVisible(true);
		        StoreScreen.main(null);
			}
		});
		btnNewButton.setBounds(199, 293, 218, 32);
		center.add(btnNewButton);
		return center;
	}
	
	public AddBookToStoreScreen() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(631, 430);
	}
	
	public static void main(String[] args) {
		new AddBookToStoreScreen();
	}
	
}
