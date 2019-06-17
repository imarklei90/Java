package edu.sse.ustc.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Component GUI
 * 
 * @author iustc
 * @since 2018.9.18
 *
 */
public class ComponentGUI {
	public static void main(String[] args) {
		JFrame frame = new BasicFramework();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		
		frame.setSize((int)screenWidth/2, (int)screenHeight/2);
		frame.setLocation(400, 300);
		
		frame.setTitle("Commponent.");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

class BasicFramework extends JFrame{

	public BasicFramework() {
		add(new BasicComponent());
		pack();
	}
}

class BasicComponent extends JComponent {
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public void paintComponent(Graphics g) {
		g.drawString("Hello World, Hello GUI", MESSAGE_X, MESSAGE_Y);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}
