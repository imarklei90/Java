package edu.sse.ustc.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * Basic GUI
 */
public class BasicGUI {

	public static void main(String[] args) {
		JFrame frame = new BasicFramework();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		double screenWidth = screenSize.getWidth();
		double screenHeight = screenSize.getHeight();
		
		frame.setSize((int)screenWidth/2, (int)screenHeight/2);
		frame.setLocation(400, 300);
		
		Image image = new ImageIcon("pic/ustc_Logo.gif").getImage();
		frame.setIconImage(image);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class BasicFrame extends JFrame{
	public BasicFrame() {
		// TODO Auto-generated constructor stub
	}
	

	
}
