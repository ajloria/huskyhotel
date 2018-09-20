package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Button;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

/**
 * Describes the number of floors in a JFrame.
 * @author Andrew Joshua Loria
 */
public class FloorFrame extends JFrame {
	
    /**Screen size.*/
    public static final Dimension MIN_SIZE = new Dimension(500, 500);
    
    /**Get screen size of device.*/
    private static final Dimension DIM = Toolkit.getDefaultToolkit().getScreenSize();

    /**Get screen width.*/
    public static final int WIDTH = DIM.width;
    
    /**Get screen height.*/
    private static final int HEIGHT = DIM.height;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1603003644495642149L;
	private JPanel contentPane;
	private static JTable myTable;

			private static void displayTable() {
				try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/loria_andrew_db?useSSL=false","root","*****");  
					Statement stmt=con.createStatement();  
					DefaultTableModel model = new DefaultTableModel(new String[]{"FloorID", "FloorName","# of Rooms"}, 0);

					String sql="SELECT * FROM hotelfloor";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next()) {
						int i = rs.getInt("FloorID");
						String a = rs.getString("FloorName");
						int b = rs.getInt("NumberOfRooms");
						model.addRow(new Object[] {i,a, b});
					}
					con.close();  
					myTable.setModel(model);
				}catch(Exception e){ 
					System.out.println(e);
					} 
			
	}

	/**
	 * Create the frame.
	 */
	public FloorFrame() {
		setTitle("View Reservations");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FloorFrame.class.getResource("/resources/w.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOkThen = new JLabel("Husky Hotel Floors Info");
		lblOkThen.setForeground(new Color(153, 50, 204));
		lblOkThen.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 12));
		lblOkThen.setBounds(154, 11, 159, 14);
		contentPane.add(lblOkThen);
		
		Button button = new Button("Make a Reservation");
		button.setBounds(175, 229, 125, 22);
		button.addActionListener(new ActionListener() 
		{
		    public void actionPerformed(ActionEvent e) {
		    	setVisible(false);
		    	try {
					HotelFrame frame = new HotelFrame();
					frame.setMinimumSize(MIN_SIZE);
				     frame.setLocation(WIDTH / 2 - frame.getWidth() / 2, 
				                            HEIGHT / 2 - frame.getHeight() / 2);
				     frame.pack();
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
		    }
		});
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 36, 270, 188);
		contentPane.add(scrollPane);
		
		myTable = new JTable();
		scrollPane.setViewportView(myTable);
		myTable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"FirstName", "LastName"
			}
		));
		displayTable();

	}
}
