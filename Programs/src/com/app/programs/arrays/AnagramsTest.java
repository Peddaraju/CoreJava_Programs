package com.app.programs.arrays;

import java.util.Arrays;

public class AnagramsTest {

	public static void main(String[] args) {
		String str1 = "Army";
		String str2 = "Mary";
		
		//boolean flag = anagramTest(str1, str2);
		boolean flag = anagramTest1(str1, str2);
		if(flag) {
			System.out.println("given strings are anagrams");
		} else {
			System.out.println("given strings are not anagrams");
		}
	}

	private static boolean anagramTest(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		char[] str1Lower = str1.toLowerCase().toCharArray();
		String str2Lower = str2.toLowerCase();
		for(char ch : str1Lower) {
			int index = str2Lower.indexOf(ch);
			if(index != -1) {
				continue;
			} else {
				return false;
			}
		}
 		return true;
	}
	
	private static boolean anagramTest1(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		
		char[] s1 = str1.toLowerCase().toCharArray();
		char[] s2 = str2.toLowerCase().toCharArray();
		Arrays.sort(s1);
		Arrays.sort(s2);
		
		return Arrays.equals(s1, s2);
	}
}
