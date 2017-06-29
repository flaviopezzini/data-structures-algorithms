package com.datastructuresalgorithms;
import org.junit.Test;

import com.datastructuresalgorithms.SmallestIntegerNotOnList;

public class SmallestIntegerNotOnListTest {
	
	@Test
	public void testFind() {
		int[] array = {0, 1, 3, 6, 1024};
		int lowest = SmallestIntegerNotOnList.findLowest(array, array.length);
		assert(lowest == 2);
	}
	
	@Test
	public void testOneElement() {
		int[] array = new int []{0};
		int lowest = SmallestIntegerNotOnList.findLowest(array, array.length);
		assert(lowest == 1);

	}
	
	@Test
	public void testEmptyArray() {
		int[] array = new int []{};
		int lowest = SmallestIntegerNotOnList.findLowest(array, array.length);
		assert(lowest == 0);

	}
	
	@Test
	public void testArrayWithBigNumbers() {
		int[] array = new int []{10241024, 7374743, 949494};
		int lowest = SmallestIntegerNotOnList.findLowest(array, array.length);
		assert(lowest == 0);

	}

}