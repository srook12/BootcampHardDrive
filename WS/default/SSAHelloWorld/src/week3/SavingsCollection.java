package week3;

import java.util.HashMap;

public class SavingsCollection extends HashMap<String, Savings> {
		
	public void add(Savings s) {
		put(s.getId(), s);
	}
}
