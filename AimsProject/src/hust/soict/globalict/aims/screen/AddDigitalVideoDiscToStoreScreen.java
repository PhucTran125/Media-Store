package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField titleField;
	private JTextField categoryField;
	private JTextField directorField;
	private JTextField lengthField;
	private JTextField costField;
	
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setBounds(100, 100, 631, 465);
		center.setLayout(null);
		
		JLabel label = new JLabel();
		
		label = new JLabel("Enter DVD data");
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
		
		label = new JLabel("Director:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 190, 79, 32);
		center.add(label);
		
		directorField = new JTextField();
		directorField.setColumns(10);
		directorField.setBounds(193, 190, 333, 32);
		center.add(directorField);
		
		label = new JLabel("Length:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 232, 79, 32);
		center.add(label);
		
		lengthField = new JTextField();
		lengthField.setColumns(10);
		lengthField.setBounds(193, 232, 333, 32);
		center.add(lengthField);
		
		label = new JLabel("Cost:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 274, 79, 32);
		center.add(label);
		
		costField = new JTextField();
		costField.setColumns(10);
		costField.setBounds(193, 274, 333, 32);
		center.add(costField);
		
		JButton btnNewButton = new JButton("ADD TO STORE");
		btnNewButton.setFont(new Font("UTM Avo", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titleString = titleField.getText().trim();
				String categoryString = categoryField.getText().trim();
				String directorString = directorField.getText().trim();
				String lengthString = lengthField.getText().trim();
				String costString = costField.getText().trim();
				Integer length = Integer.parseInt(lengthString);
				Float cost = Float.parseFloat(costString);
				DigitalVideoDisc newDvd = new DigitalVideoDisc(titleString, categoryString, directorString, length, cost);
				StoreScreen.store.addMedia(newDvd);
				// successfull
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
		btnNewButton.setBounds(199, 336, 218, 32);
		center.add(btnNewButton);
		return center;
	}
	
	public AddDigitalVideoDiscToStoreScreen() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(631, 465);
	}
	
	public static void main(String[] args) {
		new AddDigitalVideoDiscToStoreScreen();
	}
}
