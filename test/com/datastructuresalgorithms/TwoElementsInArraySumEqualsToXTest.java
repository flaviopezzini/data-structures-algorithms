package com.datastructuresalgorithms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TwoElementsInArraySumEqualsToXTest {
	
	@Test
	public void testMiddleElementsSumEqualsToX() {
		TwoElementsInArraySumEqualsToX t = new TwoElementsInArraySumEqualsToX();
		int A[] = {1, 4, 45, 6, 10, -8};
        int n = 16;
          
        assertTrue(t.hasArrayTwoCandidates(A, A.length, n));
	}
	
	@Test
	public void testDuplicatedElements() {
		TwoElementsInArraySumEqualsToX t = new TwoElementsInArraySumEqualsToX();
		int A[] = {1, 4, 45, 6, 6, 10, -8};
        int n = 16;
          
        assertTrue(t.hasArrayTwoCandidates(A, A.length, n));
	}
	
	@Test
	public void testMoreThanOnePair() {
		TwoElementsInArraySumEqualsToX t = new TwoElementsInArraySumEqualsToX();
		int A[] = {1, 4, 45, 6, 10, -8, 24};
        int n = 16;
          
        assertTrue(t.hasArrayTwoCandidates(A, A.length, n));
	}
	
	@Test
	public void testNoElements() {
		TwoElementsInArraySumEqualsToX t = new TwoElementsInArraySumEqualsToX();
		int A[] = {1, 4, 45, 10, -8};
        int n = 16;
          
        assertFalse(t.hasArrayTwoCandidates(A, A.length, n));
	}
}