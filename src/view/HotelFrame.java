/**
 * @author Andrew Joshua Loria
 */

package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;

import com.jgoodies.forms.factories.DefaultComponentFactory;
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

public class HotelFrame extends JFrame {
	
    /**Screen size.*/
    public static final Dimension MIN_SIZE = new Dimension(500, 500);
    
    /**Get screen size of device.*/
    private static final Dimension DIM = Toolkit.getDefaultToolkit().getScreenSize();

    /**Get screen width.*/
    public static final int WIDTH = DIM.width;
    
    /**Get screen height.*/
    private static final int HEIGHT = DIM.height;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_7;
	private JLabel lblWelcomeToThe;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Create the frame.
	 */
	public HotelFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HotelFrame.class.getResource("/resources/w.gif")));
		setTitle("Husky Hotel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblFirstName.setBounds(10, 38, 81, 14);
		contentPane.add(lblFirstName);
		
		textField = new JTextField();
		textField.setBounds(89, 35, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		String firstName = textField.getText();
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblLastName.setBounds(201, 38, 66, 14);
		contentPane.add(lblLastName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(277, 35, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		String lastName = textField_1.getText();

		
		JLabel lblStreetAddress = new JLabel("Street Address");
		lblStreetAddress.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblStreetAddress.setBounds(10, 63, 132, 14);
		contentPane.add(lblStreetAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 60, 213, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(50);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblCity.setBounds(10, 88, 46, 14);
		contentPane.add(lblCity);
		
		textField_3 = new JTextField();
		textField_3.setBounds(37, 85, 72, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblState.setBounds(160, 88, 46, 14);
		contentPane.add(lblState);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblZip.setBounds(259, 88, 46, 14);
		contentPane.add(lblZip);
		
		textField_4 = new JTextField();
		textField_4.setBounds(297, 85, 66, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(201, 85, 35, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(2);
		
		
		JLabel lblCheckInDate = new JLabel("Check In Date");
		lblCheckInDate.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblCheckInDate.setBounds(10, 119, 81, 14);
		contentPane.add(lblCheckInDate);
		
		textField_6 = new JTextField();
		textField_6.setBounds(123, 116, 86, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblCheckoutdate = new JLabel("CheckOutDate");
		lblCheckoutdate.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblCheckoutdate.setBounds(10, 147, 117, 14);
		contentPane.add(lblCheckoutdate);
		
		table = new JTable();
		table.setBounds(315, 184, 1, 1);
		contentPane.add(table);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(123, 144, 86, 20);
		contentPane.add(textField_7);
		
		lblWelcomeToThe = new JLabel("Welcome to the Husky Hotel!");
		lblWelcomeToThe.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblWelcomeToThe.setForeground(new Color(75, 0, 130));
		lblWelcomeToThe.setBounds(150, 0, 203, 24);
		
		Button button = new Button("View Reservations");
		button.setBackground(new Color(128, 0, 128));
		button.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 12));
		button.setForeground(new Color(255, 255, 0));
		button.setActionCommand("View Existing Reservations");
		button.setBounds(119, 227, 117, 22);
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
		
		JLabel lblWelcomeToThe_1 = new JLabel("Welcome to the Husky Hotel!");
		lblWelcomeToThe_1.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 15));
		lblWelcomeToThe_1.setForeground(new Color(148, 0, 211));
		lblWelcomeToThe_1.setBounds(89, 0, 302, 25);
		contentPane.add(lblWelcomeToThe_1);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblPhone.setBounds(233, 119, 46, 14);
		contentPane.add(lblPhone);
		
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblEmail.setBounds(233, 147, 46, 14);
		contentPane.add(lblEmail);
		
		textField_8 = new JTextField();
		textField_8.setBounds(277, 116, 86, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		String phone = textField_8.getText();

		
		textField_9 = new JTextField();
		textField_9.setBounds(277, 144, 86, 20);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		String email = textField_9.getText();
		

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnSubmit.setBackground(new Color(128, 0, 128));
		btnSubmit.setOpaque(true);
		btnSubmit.setForeground(new Color(255, 255, 0));
		btnSubmit.setBounds(10, 227, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().isEmpty()||(textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textField_3.getText().isEmpty() ||(textField_4.getText().isEmpty())))
					JOptionPane.showMessageDialog(null, "Data Missing");
				else {		
						JOptionPane.showMessageDialog(null, "You have placed your reservation!");
					try{  
						Class.forName("com.mysql.jdbc.Driver");  
						/*Note: DriverManager connection code has been omitted for confidentiality */
						Connection con= DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/loria_andrew_db?useSSL=false","root","*******");  
						String query = "INSERT INTO Guest VALUES(?,?,?,?,?)";
						String sql="SELECT MAX(GuestID) FROM Guest";

						PreparedStatement pst = con.prepareStatement(query);
						PreparedStatement pst2 = con.prepareStatement(sql);
						ResultSet rs = pst2.executeQuery(sql);
						int guestID = 0;
						while(rs.next()) {
							guestID = rs.getInt(1); //get the last inserted GuestID
						}
						guestID = guestID + 1;
						pst.setInt(1, guestID);
						pst.setString(2, textField.getText());
						pst.setString(3, textField_1.getText());
						pst.setString(4, textField_8.getText());
						pst.setString(5, textField_9.getText());
						pst.executeUpdate();
						con.close();  
					}catch(Exception e){ 
						System.out.println(e);
						}  
				}
			}
		});
		contentPane.add(btnSubmit);
		
		JLabel lblRoomType = new JLabel("Room Type");
		lblRoomType.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		lblRoomType.setBounds(10, 172, 99, 20);
		contentPane.add(lblRoomType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select...", "Single", "Suite", "Executive"}));
		comboBox.setBounds(123, 172, 83, 20);
		contentPane.add(comboBox);
		
		JButton btnMoreOptions = new JButton("More Options");
		btnMoreOptions.setBackground(new Color(128, 0, 128));
		btnMoreOptions.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnMoreOptions.setForeground(new Color(255, 255, 0));
		btnMoreOptions.setBounds(242, 226, 118, 23);
		btnMoreOptions.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	try {
					OptionsFrame optFrame = new OptionsFrame();
					optFrame.setMinimumSize(MIN_SIZE);
					optFrame.setLocation(WIDTH / 2 - optFrame.getWidth() / 2, 
				                            HEIGHT / 2 - optFrame.getHeight() / 2);
					optFrame.pack();
					optFrame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
		    }
		});
		contentPane.add(btnMoreOptions);

	}
}
