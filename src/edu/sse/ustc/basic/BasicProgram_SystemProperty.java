package edu.sse.ustc.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class BasicProgram_SystemProperty {
	public static void main(String[] args) throws IOException {
		String dir = System.getProperty("user.dir");
		System.out.println("dir: " + dir);
		
		File file = new File(System.getProperty("user.dir") + "/data/user.txt");
		String line = null;
		BufferedReader reader = new BufferedReader(new FileReader(file));
		while((line = reader.readLine()) != null) {
			System.err.println("User: " + line.trim());
		}
	}
}
