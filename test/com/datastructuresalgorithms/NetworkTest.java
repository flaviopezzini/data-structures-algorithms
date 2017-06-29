package com.datastructuresalgorithms;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.datastructuresalgorithms.Network;

public class NetworkTest {
	
	@Test
	public void testSizeValidation() {
		try {
			// negative size network
			new Network(-1);
			fail("It should have thrown an exception");
		} catch (IllegalArgumentException iae) {
			// do nothing, this is expected
		}
		try {
			// empty network
			new Network(0);
			// valid size network
			new Network(1);
		} catch (Throwable e) {
			fail("It should not have thrown an exception");
		}
	}
	
	@Test
	public void testConnect() {
		Network network = new Network(0);
		try {
			network.connect(1, 2);
			fail("It should have thrown an exception that the capacity has reached the limit");
		} catch (RuntimeException re) {
			// do nothing, this is expected
		}
		
		Network network2 = new Network(2);
		try {
			network2.connect(1, 2);
			network2.connect(1, 3);
			fail("It should have thrown an exception that the capacity has reached the limit");
		} catch (RuntimeException re) {
			// do nothing, this is expected
		}
		Network network3 = new Network(3);
		try {
			network3.connect(1, 2);
			network3.connect(1, 3);
		} catch (RuntimeException re) {
			fail("It should not have thrown an exception, the size is 3 and there are 3 elements");
		}
	}
	
	@Test
	public void testQuery() {
		Network network = new Network(8);
		network.connect(1, 2);
		network.connect(6, 2);
		network.connect(2, 4);
		network.connect(5, 8);
		network.connect(4, 8);
		assertTrue(network.query(1, 4));
		assertTrue(network.query(1, 6));
		assertTrue(network.query(1, 2));
		assertTrue(network.query(5, 8));
		assertFalse(network.query(3, 5));
		assertTrue(network.query(4, 5));
		assertTrue(network.query(1, 5));
	}
}