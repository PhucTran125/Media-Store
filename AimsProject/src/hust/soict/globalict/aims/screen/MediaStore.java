package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.LimitExceededException;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;


public class MediaStore extends JPanel {
	private Media media;
	public MediaStore(Media media) {
		FunctionActionListener functionActionListener = new FunctionActionListener();
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCart = new JButton("Add to cart");
		addToCart.addActionListener(functionActionListener);
		container.add(addToCart);
		
		if (media instanceof Playable) {
			JButton playButton = new JButton("Play");
			playButton.addActionListener(functionActionListener);
			container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	private class FunctionActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String option = e.getActionCommand();
			if (option.equals("Add to cart")) {
				Cart cart = StoreScreen.cart;
				try {
					cart.addMedia(media);
				} catch (LimitExceededException e1) {
					e1.printStackTrace();
				}
				JFrame f = new JFrame();
		        JDialog d = new JDialog(f , "Add to cart successfully!", true);  
		        d.setLayout(new FlowLayout());  
		        JButton b = new JButton ("OK");  
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
			if (option.equals("Play")){
				JFrame f = new JFrame();
		        JDialog d = new JDialog(f , "Play box!!!", true);  
		        d.setLayout(new FlowLayout());  
		        JButton b = new JButton ("Finish");  
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
		}
	}
}
