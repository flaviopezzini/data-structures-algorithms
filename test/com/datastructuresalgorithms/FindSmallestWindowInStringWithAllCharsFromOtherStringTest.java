package com.datastructuresalgorithms;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindSmallestWindowInStringWithAllCharsFromOtherStringTest {
	
	@Test
	public void testFind() {
		String input = "this is a test string";
		String pattern = "tist";
		String smallestWindow = new FindSmallestWindowInStringWithAllCharsFromOtherString().findSmallestSubStringWithAllChars(input, pattern);
		assertEquals("t stri", smallestWindow);
	}
	
	@Test
	public void testFind2() {
		String input = "geeksforgeeks";
		String pattern = "ork";
		String smallestWindow = new FindSmallestWindowInStringWithAllCharsFromOtherString().findSmallestSubStringWithAllChars(input, pattern);
		assertEquals("ksfor", smallestWindow);
	}

}