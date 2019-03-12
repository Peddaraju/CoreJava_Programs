package com.app.programs.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateElementsInArray {

	public static void main(String[] args) {
		String[] withDuplicates = new String[] {"one","two","three","one"};
		//bruteforce(withDuplicates);
		//checkDuplicateUsingSet(withDuplicates);
		//checkDuplicateUsingSetAdd(withDuplicates);
		
		int[] numbers = new int[] {1,3,5,4,1,2,3,5,4,7,6,7};
		//printDupNumbers(numbers);
		
		
		//java 8
		printDupNumbersJava8(new Integer[] {1,3,5,4,1,2,3,5,4,7,6,7});
		printDupNumbersJava8(withDuplicates);
	}


	private static void printDupNumbersJava8(Integer[] numbers) {
		List<Integer> list = Arrays.asList(numbers);
		
		Set<Integer> duplicates = list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet());
		System.out.println(duplicates);
	}
	private static void printDupNumbersJava8(String[] withDuplicates) {
		List<String> list = Arrays.asList(withDuplicates);
		Set<String> set = new HashSet();
		//Set<String> duplicates = list.stream().filter(i -> Collections.frequency(list, i) > 1).collect(Collectors.toSet());
		Set<String> duplicates = list.stream().filter(i -> !(set.add(i))).collect(Collectors.toSet());
		System.out.println(duplicates);
		
	}
	private static void checkDuplicateUsingSetAdd(String[] withDuplicates) {
		List<String> duplicate = new ArrayList<>();
		Set<String> set = new HashSet<>();
		for (String string : withDuplicates) {
			if (!set.add(string)) {
				duplicate.add(string);
			}
		}
		System.out.println("Duplicate in the given sequence is :" + duplicate);
	}

	private static void checkDuplicateUsingSet(String[] withDuplicates) {
		List<String> list = Arrays.asList(withDuplicates);
		Set<String> set = new HashSet<>(list);
		
		System.out.println(Collections.disjoint(list, set));
		
		/*if (list.size() == set.size()) {
			System.out.println("no duplicate elements");
		} else {
			System.out.println("duplicates are there");
		}*/
		 
	}

	private static void bruteforce(String[] withDuplicates) {
		List<String> duplicate =new ArrayList();
		for (int i = 0; i < withDuplicates.length; i++) {
			for (int j = 0; j < withDuplicates.length; j++) {
				if (withDuplicates[i].equals(withDuplicates[j]) && i != j) {
					duplicate.add(withDuplicates[i]);
				}
			}
		}
		System.out.println("Duplicate in the given sequence is :" + duplicate);
	}

	private static void printDupNumbers(int[] numbers) {
		System.out.println(Arrays.toString(numbers));
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		
		List<Integer> duplicate =new ArrayList();
		for(int i = 0; i < numbers.length-1; i++) {
			if (numbers[i] == numbers[i+1]) {
				duplicate.add(numbers[i]);
			}
		}
		System.out.println("Duplicate number in the given sequence is :" + duplicate);
	}
}
