package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Button;
import java.awt.Toolkit;
import javax.swing.DefaultComboBoxModel;


/**
 * 
 * @author Andrew Joshua Loria
 *
 */
public class OptionsFrame extends JFrame {
	
    /**Screen size.*/
    public static final Dimension MIN_SIZE = new Dimension(500, 500);
    
    /**Get screen size of device.*/
    private static final Dimension DIM = Toolkit.getDefaultToolkit().getScreenSize();

    /**Get screen width.*/
    public static final int WIDTH = DIM.width;
    
    /**Get screen height.*/
    private static final int HEIGHT = DIM.height;

	private JPanel contentPane;
	private JTable table;
	private JLabel lblWelcomeToThe;


	/**
	 * Create the frame.
	 */
	public OptionsFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(OptionsFrame.class.getResource("/resources/w.gif")));
		setTitle("Husky Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(315, 184, 1, 1);
		contentPane.add(table);
		
		lblWelcomeToThe = new JLabel("Welcome to the Husky Hotel!");
		lblWelcomeToThe.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblWelcomeToThe.setForeground(new Color(75, 0, 130));
		lblWelcomeToThe.setBounds(150, 0, 203, 24);
		
		Button button = new Button("View Reservations");
		button.setBackground(new Color(128, 0, 128));
		button.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		button.setForeground(new Color(255, 255, 0));
		button.setActionCommand("View Existing Reservations");
		button.setBounds(253, 67, 117, 22);
		button.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	try {
					TableFrame frame = new TableFrame();
					 frame.setMinimumSize(MIN_SIZE);
				     frame.setLocation(WIDTH / 2 - frame.getWidth() / 2, 
				                            HEIGHT / 2 - frame.getHeight() / 2);
				     frame.pack();
					 frame.setVisible(true);
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
		    }
		});
		contentPane.add(button);
		
		JLabel lblWelcomeToThe_1 = new JLabel("Select an Option Below");
		lblWelcomeToThe_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblWelcomeToThe_1.setForeground(new Color(148, 0, 211));
		lblWelcomeToThe_1.setBounds(122, 11, 302, 25);
		contentPane.add(lblWelcomeToThe_1);
		

		JButton btnSubmit = new JButton("View Hotel Restaurants");
		btnSubmit.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnSubmit.setBackground(new Color(128, 0, 128));
		btnSubmit.setOpaque(true);
		btnSubmit.setForeground(new Color(255, 255, 0));
		btnSubmit.setBounds(10, 67, 153, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    	setVisible(false);
		    	try {
					RestaurantFrame frame = new RestaurantFrame();
					 frame.setMinimumSize(MIN_SIZE);
				     frame.setLocation(WIDTH / 2 - frame.getWidth() / 2, 
				                            HEIGHT / 2 - frame.getHeight() / 2);
				     frame.pack();
					 frame.setVisible(true);
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		contentPane.add(btnSubmit);
		
		JButton btnMoreOptions = new JButton("Floor Info");
		btnMoreOptions.setBackground(new Color(128, 0, 128));
		btnMoreOptions.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnMoreOptions.setForeground(new Color(255, 255, 0));
		btnMoreOptions.setBounds(10, 144, 118, 23);
		btnMoreOptions.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	try {
					FloorFrame floor = new FloorFrame();
					floor.setMinimumSize(MIN_SIZE);
					floor.setLocation(WIDTH / 2 - floor.getWidth() / 2, 
				                            HEIGHT / 2 - floor.getHeight() / 2);
					floor.pack();
					floor.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
		    }
		});
		contentPane.add(btnMoreOptions);

	}
}
