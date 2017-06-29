package com.datastructuresalgorithms;


import java.util.HashMap;
import java.util.HashSet;

public class Network {

	private int size;
	private HashMap<Integer, HashSet<Integer>> map;
	
	public Network(int size) {
		if (size < 0) {
			throw new IllegalArgumentException("The size parameter must be greater or equal to zero");
		}
		this.size = size;
		map = new HashMap<>();
	}
	
	public void connect(int a, int b) {
		// limit check
		if (map.size() == this.size) {
			if (isEitherANewElement(a, b)) {
				throw new RuntimeException("Set limit reached, you can no longer add new numbers to it.");
			}
		}
		HashSet<Integer> connectionsA = map.get(a);
		if (connectionsA == null) {
			connectionsA = new HashSet<Integer>();
		}
		connectionsA.add(b);
		map.put(a,  connectionsA);
		HashSet<Integer> connectionsB = map.get(b);
		if (connectionsB == null) {
			connectionsB = new HashSet<Integer>();
		}
		connectionsB.add(a);
		map.put(b,  connectionsB);
	}
	
	private boolean query(int a, int b, HashSet<Integer> processed) {
		if (processed.contains(b)) {
			return false;
		}
		HashSet<Integer> connectionsA = map.get(a);
		HashSet<Integer> connectionsB = map.get(b);
		if (connectionsA.contains(b)) { // no need to test the other side
			return true;
		} else {
			processed.add(b);
			for (Integer num : connectionsB) {
				return query(a, num, processed);
			}
			return false;
		}
	}
	
	public boolean query(int a, int b) {
		if (isEitherANewElement(a, b)) {
			return false;
		}
		HashSet<Integer> processed = new HashSet<>();
		return query(a, b, processed);
	}
	
	private boolean isEitherANewElement(int a, int b) {
		return !map.containsKey(a) || !map.containsKey(b);
	}
}