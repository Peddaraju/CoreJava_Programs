package com.app.programs.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateCharInString {

	public static void main(String[] args) {
		String str = "java";
		Map<Character, Integer> duplicates = findDuplicate(str);
		Set<Map.Entry<Character, Integer>> set = duplicates.entrySet();
		for(Map.Entry<Character, Integer> entry : set) {
			if (entry.getValue() >1) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
	}

	private static Map<Character, Integer> findDuplicate(String str) {
		char[] charArray = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : charArray) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c)+1);
			}
		}
		return map;
	}
}
