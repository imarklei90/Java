package edu.sse.ustc.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * define a exception class 
 * @author iustc
 * @since 2018.08.25
 *
 */
public class BasicException extends IOException {

	public BasicException() {
		
	}
		
	public BasicException(String message) {
		super(message);
	}
	
	public void read() {
		try {
			String message = ""; // exception
			throw new BasicException("exception message: " + message);
		}catch (Exception e) {
			e.getMessage();
			e.getClass().getName();// get exception object type
		}
	}
	
	public void getScannerData() throws FileNotFoundException{
		try(Scanner in = new Scanner(new FileInputStream(new File("")), "UTF-8")){
			while(in.hasNext()) {
				System.out.println(in.next());
			}
		}
	}
			
}
