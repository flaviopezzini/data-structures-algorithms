package com.datastructuresalgorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindSmallestWindowInStringWithAllCharsFromOtherString {
	
	private Map<Character, Integer> frequency;
	private Set<Character> charsCovered;
	private Map<Character, Integer> encountered;
	
	/**
	 * To set the first match index as an initial start point
	 */
	private boolean hasStarted = false;
	private int currentStartIndex = 0;
	private int finalStartIndex = 0;
	private int finalEndIndex = 0;
	private  int minLen = Integer.MAX_VALUE;
	private int currentLen = 0;
	
	/**
	 * Whether we have already found the match and now looking for other
	 * alternatives.
	 */
	private boolean isFound = false;
	private char currentChar;

	public String findSmallestSubStringWithAllChars(String big, String small) {

	    if (null == big || null == small || big.isEmpty() || small.isEmpty()) {
	        return null;
	    }

	    frequency = new HashMap<Character, Integer>();
	    instantiateFrequencyMap(small);
	    charsCovered = new HashSet<Character>();
	    int charsToBeCovered = frequency.size();
	    encountered = new HashMap<Character, Integer>();

	    for (int i = 0; i < big.length(); i++) {
	        currentChar = big.charAt(i);
	        if (frequency.containsKey(currentChar) && !isFound) {
	            if (!hasStarted && !isFound) {
	                hasStarted = true;
	                currentStartIndex = i;
	            }
	            updateEncounteredMapAndCharsCoveredSet(currentChar);
	            if (charsCovered.size() == charsToBeCovered) {
	                currentLen = i - currentStartIndex;
	                isFound = true;
	                updateMinLength(i);
	            }
	        } else if (frequency.containsKey(currentChar) && isFound) {
	            updateEncounteredMapAndCharsCoveredSet(currentChar);
	            if (currentChar == big.charAt(currentStartIndex)) {
	                encountered.put(currentChar, encountered.get(currentChar) - 1);
	                currentStartIndex++;
	                while (currentStartIndex < i) {
	                    if (encountered.containsKey(big.charAt(currentStartIndex))
	                            && encountered.get(big.charAt(currentStartIndex)) > frequency.get(big
	                                    .charAt(currentStartIndex))) {
	                        encountered.put(big.charAt(currentStartIndex),
	                                encountered.get(big.charAt(currentStartIndex)) - 1);
	                    } else if (encountered.containsKey(big.charAt(currentStartIndex))) {
	                        break;
	                    }
	                    currentStartIndex++;
	                }
	            }
	            currentLen = i - currentStartIndex;
	            updateMinLength(i);
	        }
	    }
	    System.out.println("start: " + finalStartIndex + " finalEnd : " + finalEndIndex);
	    return big.substring(finalStartIndex, finalEndIndex + 1);
	}

	private void updateMinLength(int index) {
	    if (minLen > currentLen) {
	        minLen = currentLen;
	        finalStartIndex = currentStartIndex;
	        finalEndIndex = index;
	    }
	}

	private void updateEncounteredMapAndCharsCoveredSet(Character currentChar) {
	    if (encountered.containsKey(currentChar)) {
	        encountered.put(currentChar, encountered.get(currentChar) + 1);
	    } else {
	        encountered.put(currentChar, 1);
	    }

	    if (encountered.get(currentChar) >= frequency.get(currentChar)) {
	        charsCovered.add(currentChar);
	    }
	}

	private void instantiateFrequencyMap(String str) {

	    for (char c : str.toCharArray()) {
	        if (frequency.containsKey(c)) {
	            frequency.put(c, frequency.get(c) + 1);
	        } else {
	            frequency.put(c, 1);
	        }
	    }
	}
}