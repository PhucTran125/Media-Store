package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	private JTextField titleField;
	private JTextField categoryField;
	private JTextField artistField;
	private JTextField directorField;
	private JTextField lengthField;
	private JTextField costField;
	
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setBounds(100, 100, 686, 565);
		center.setLayout(null);
		
		JLabel label = new JLabel();
		
		label = new JLabel("Enter CD data");
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
		
		label = new JLabel("Artist:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 190, 79, 32);
		center.add(label);
		
		artistField = new JTextField();
		artistField.setColumns(10);
		artistField.setBounds(193, 190, 333, 32);
		center.add(artistField);
		
		label = new JLabel("Director:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 232, 79, 32);
		center.add(label);
		
		directorField = new JTextField();
		directorField.setColumns(10);
		directorField.setBounds(193, 232, 333, 32);
		center.add(directorField);
		
		label = new JLabel("Length:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 316, 79, 32);
		center.add(label);
		
		lengthField = new JTextField();
		lengthField.setColumns(10);
		lengthField.setBounds(193, 316, 333, 32);
		center.add(lengthField);
		
		label = new JLabel("Cost:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 358, 79, 32);
		center.add(label);
		
		costField = new JTextField();
		costField.setColumns(10);
		costField.setBounds(193, 358, 333, 32);
		center.add(costField);
		
		JButton btnNewButton = new JButton("ADD TO STORE");
		btnNewButton.setFont(new Font("UTM Avo", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titleString = titleField.getText().trim();
				String categoryString = categoryField.getText().trim();
				String artistString = artistField.getText().trim();
				String directorString = directorField.getText().trim();
				String lenString = lengthField.getText().trim();
				Integer length = Integer.parseInt(lenString);
				String costString = costField.getText().trim();
				Float cost = Float.parseFloat(costString);
				CompactDisc newCD = new CompactDisc(titleString, categoryString, artistString, directorString, length, cost);
				int i;
				for (i = 0; i < AddTracksToCD.tracks.size(); i++) {
					newCD.addTrack(AddTracksToCD.tracks.get(i));
					
				}
				StoreScreen.store.addMedia(newCD);
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
		btnNewButton.setBounds(227, 434, 218, 32);
		center.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add tracks");
		btnNewButton_1.setFont(new Font("UTM Avo", Font.PLAIN, 14));
		btnNewButton_1.setBounds(193, 274, 120, 32);
		center.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddTracksToCD();
			}
		});
		return center;
	}
	
	public AddCompactDiscToStoreScreen() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(686, 565);
	}
	
	public static void main(String[] args) {
		new AddCompactDiscToStoreScreen();
	}
}
