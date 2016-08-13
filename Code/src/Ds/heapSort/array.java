package Ds.heapSort;

import java.util.Arrays;


public class array {
	public static void main(String []  args) {
		int[] b = {1,2,3,4,5,6};
		 
		int[] c = b;
		for (int j : c) {
			System.out.print(j + "\t");	
		}
		System.out.println();
		
		
		c = Arrays.copyOf(c, 4);
		for (int j : c) {
			System.out.print(j + "\t");	
		}
		
	}

}
