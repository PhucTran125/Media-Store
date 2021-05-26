package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.media.jfxmedia.track.Track;
 
public class AddTracksToCD extends AddItemToStoreScreen{
	protected static ArrayList<hust.soict.globalict.aims.media.Track> tracks = new ArrayList<hust.soict.globalict.aims.media.Track>();
	private JTextField titleField;
	private JTextField lengField;
	
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setBounds(100, 100, 644, 367);
		center.setLayout(null);
		
		JLabel label = new JLabel();
		
		
		label = new JLabel("Enter CD's tracks");
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
		
		JButton btnNewButton = new JButton("Add to CD");
		btnNewButton.setFont(new Font("UTM Avo", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = titleField.getText().trim();
				String length = lengField.getText().trim();
				Integer lengInteger = Integer.parseInt(length);
				hust.soict.globalict.aims.media.Track track = new hust.soict.globalict.aims.media.Track(title, lengInteger);
				tracks.add(track);
				JFrame f = new JFrame();
		        JDialog d = new JDialog(f , "Adding track successfully!!!", true);  
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
			}
		});
		btnNewButton.setBounds(130, 224, 144, 32);
		center.add(btnNewButton);
		
		label = new JLabel("Length:");
		label.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		label.setBounds(92, 148, 79, 32);
		center.add(label);
		
		lengField = new JTextField();
		lengField.setColumns(10);
		lengField.setBounds(193, 148, 333, 32);
		center.add(lengField);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				titleField.setText("");
				lengField.setText("");
			}
		});
		btnClear.setFont(new Font("UTM Avo", Font.BOLD, 14));
		btnClear.setBounds(352, 224, 144, 32);
		center.add(btnClear);
		return center;
	}
	
	public AddTracksToCD() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(644, 367);
	}
}
