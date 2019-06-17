package edu.sse.ustc.object;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class DateObject {
	public static void main(String[] args) {
		// Date
		System.out.println(new Date());
		
		// LocalDate
		LocalDate nowDate = LocalDate.of(2018, 8, 22);
		System.out.println("nowDate: " + nowDate);
		System.out.println("Year: " + nowDate.getYear());
		System.out.println("Month: " + nowDate.getMonth());
		System.out.println("Day: " + nowDate.getDayOfMonth());
		
		// toString()
		int[] arr = {1,2,3,4,5};
		System.out.println("arr: " + arr.toString());
		
		System.out.println("arr: " + Arrays.toString(arr));
	}

}
