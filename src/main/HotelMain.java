/**
 * Hotel Database Project
 * User Interface
 */
package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import view.HotelFrame;

/**
 * @author Andrew Joshua Loria
 *
 */
public class HotelMain {
	
    /**Screen size.*/
    public static final Dimension MIN_SIZE = new Dimension(500, 500);
    
    /**Get screen size of device.*/
    private static final Dimension DIM = Toolkit.getDefaultToolkit().getScreenSize();

    /**Get screen width.*/
    public static final int WIDTH = DIM.width;
    
    /**Get screen height.*/
    private static final int HEIGHT = DIM.height;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HotelFrame frame = new HotelFrame();
					 frame.setMinimumSize(MIN_SIZE);
				     frame.setLocation(WIDTH / 2 - frame.getWidth() / 2, 
				                            HEIGHT / 2 - frame.getHeight() / 2);
				     frame.pack();
					 frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}


