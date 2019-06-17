package edu.sse.ustc.interfaces;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class BasicInterface_Timer {

	public static void main(String[] args) {
		ActionListener listener = new TimePrinter();
		Timer timer = new Timer(10000, listener);
		timer.start();
		
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);

	}
	

}

class TimePrinter implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println("Current Time : " + new Date());
		Toolkit.getDefaultToolkit().beep();
	}
	
}
