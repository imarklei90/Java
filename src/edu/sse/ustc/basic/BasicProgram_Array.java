package edu.sse.ustc.basic;

import java.util.Arrays;

public class BasicProgram_Array {
	public static void main(String[] args) {
		int[] arr = new int[10];
		int[] arr2 = {1,3,5,7,9};
		for(int i = 0; i < 10; i++) {
			arr[i] = i;
		}
		
		System.out.println("arr:" + Arrays.toString(arr));
		System.out.println("arr2: " + Arrays.toString(arr2));
		
		System.out.println("arr3: " + Arrays.toString(Arrays.copyOf(arr, arr.length)));
		System.out.println("arr3: " + Arrays.toString(Arrays.copyOf(arr2, 2)));
		System.out.println("arr3: " + Arrays.toString(Arrays.copyOfRange(arr, arr.length -2, arr.length -1)));
	}
}
