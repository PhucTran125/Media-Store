package hust.soict.globalict.aims.screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JMenu;
import javax.swing.JPanel;

public class test {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter CD's tracks");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("UTM Avo", Font.BOLD, 22));
		lblNewLabel.setBounds(193, 30, 191, 66);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(92, 106, 79, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(193, 106, 333, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add to CD");
		btnNewButton.setFont(new Font("UTM Avo", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(130, 224, 144, 32);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Length:");
		lblNewLabel_1_1_2_1.setFont(new Font("UTM Avo", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(92, 148, 79, 32);
		frame.getContentPane().add(lblNewLabel_1_1_2_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(193, 148, 333, 32);
		frame.getContentPane().add(textField_4);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setFont(new Font("UTM Avo", Font.BOLD, 14));
		btnClear.setBounds(352, 224, 144, 32);
		frame.getContentPane().add(btnClear);
	}
}
