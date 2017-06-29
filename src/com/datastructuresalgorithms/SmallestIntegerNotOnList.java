package com.datastructuresalgorithms;
import java.util.HashMap;

public class SmallestIntegerNotOnList {

	public static void main(String[] args) {
		int[] array = {0, 1, 3, 6, 1024};
		int n = array.length;

		int lowest = findLowest(array, n);
		System.out.println("Lowest is: " + lowest);
	}
	
	public static int findLowest(int[] array, int n) {
		HashMap<Integer, Boolean> map = new HashMap<>(0);
		int i = 0;
		while (i < n && array[i]< n) {
			map.put(array[i], true);
			i++;
		}
		boolean found = false;
		int positionOfLowest = 0;
		while (!found) {
			if (map.get(positionOfLowest) == null) {
				break;
			}
			positionOfLowest++;
		}
		return positionOfLowest;
	}
	
}
