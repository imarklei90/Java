package edu.sse.ustc.gui;

import java.awt.Frame;

import javax.swing.JFrame;

/**
 * Basic GUI Program
 * @author iustc
 *
 */
public class FirstGUI {
	public static void main(String[] args) {
		JFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(600, 300);
		
		frame.setTitle("第一个简单的图形界面程序");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}

class SimpleFrame extends JFrame{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	
	public SimpleFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
}