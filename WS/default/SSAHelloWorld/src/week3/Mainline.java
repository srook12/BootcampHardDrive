package week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Mainline {

	public static void main(String[] args) {
		HashMap<String, String> theStates = new HashMap<String, String>();
		theStates.put("MD", "Maryland");
		theStates.put("VA", "Virginia");
		theStates.put("PA", "Pennsylvania");
		theStates.put("DE", "Delaware");
		theStates.put("WV", "West Virginia");
		
		String stateName = theStates.get("vA");
		System.out.println(stateName);
		
		System.out.println(theStates.isEmpty());
		//theStates.clear();
		System.out.println(theStates.get("PA"));
		
		theStates.put("PA", "Not Penn");
		System.out.println(theStates.get("PA"));
		Set<String> keys = theStates.keySet();
		for(String key : keys) {
			System.out.println(theStates.get(key));
		}
		
		HashMap<String, String> pOpt = new HashMap<String, String>();
		pOpt.put("ProgramName", "The SSA Sales System");
		pOpt.put("SystemAvailable", "false");
		pOpt.put("VersionNumber", "");
		
		SavingsCollection myCustAccts = new SavingsCollection();
		Savings s1 = new Savings();
		Savings s2 = new Savings();
		Savings s3 = new Savings();
		myCustAccts.add(s1);
		myCustAccts.add(s2);
		myCustAccts.add(s3);
		
		System.out.println("Items in collection " + myCustAccts.size());
	}

}

class Savings {
	
	private int id;
	private static int nextNum = 1;
	
	public Savings() {
		id = nextNum;
		nextNum++;
	}
	
	public String getId() {
		return String.valueOf(id);
	}
}
