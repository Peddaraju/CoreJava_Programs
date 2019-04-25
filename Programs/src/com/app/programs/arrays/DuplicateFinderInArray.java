package com.app.programs.arrays;

public class DuplicateFinderInArray {

	public static void main(String[] args) {
		
		System.out.println(Integer.MIN_VALUE);
		
		
		/*int[] array = {1, 2, 3, 5, 6, 7, 8, 9};
		float dupVal = findDuplicates(array);
		if (dupVal != 0) {
			System.out.println("Duplicate Val:"+dupVal);
		} else {
			System.out.println("no duplicate in arrya");
		}*/
	}

	private static float findDuplicates(int[] array) {
		
		int actSum = 0; 
		for (int i = 0; i < array.length; i++) {
			actSum +=array[i];
		}
		float desSum = ((float)(array.length + 1) / 2) * ((array.length+2));
		
		System.out.println(actSum);
		System.out.println(desSum);
		float difference = desSum - actSum;
		
		
		
		return difference;
	}
}
