package census;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CensusExponential {
	private static java.util.Random rnd = new java.util.Random((new java.util.Date()).getTime());
	
	static List<Long> integerList = new ArrayList<Long>();
	
	static List<Long> solution = new ArrayList<Long>();
	
	static long targetSum;
		
	static int powerConstant;
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("CensusExponential started at " + startTime + " ms");
		
		if(args.length != 2) {
			System.err.println("Usage: CensusExponential <List of #s> <Target Sum>");
			System.exit(1);
		}
				
		List<String> fileContents = FileUtils.getFileContents(args[0]);
		loadNumbers(fileContents);
		
		powerConstant = (int) Math.pow(2, integerList.size());
		
		targetSum = Long.parseLong(args[1]);
		
		algorithmSort(true);
		
		// Random number generation
		//while(!findAPossibility(integerList.toArray(), getRandomNumber()));
		
		// Listing all possibilities
		findAllPossibilities(integerList.toArray());
		
		
		System.out.print("Solution: ");
		for(Long num : solution) {
			System.out.print(num + " ");
		}
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("CensusExponential ended at " + endTime + " ms");		
		System.out.println("CensusExponential took " + (endTime-startTime)/1000.0 + " s to run.");
	}
	
	public static void algorithmSort(boolean isRandom) {
		Collections.sort(integerList);
		if(!isRandom) {
			findAllPossibilities(integerList.toArray());
		} else {
			while(!findAPossibility(integerList.toArray(), getRandomNumber()));
		}
	}
	
	public static boolean findAPossibility(Object[] nums, int index) {
		List<Long> onePossibility = new ArrayList<Long>();
		int residue = index;
		long sum = 0;
		boolean foundIt = false;
		int powerConstantTemp = powerConstant;
		for(int j = 0; j < nums.length; j++) {
			int k = (nums.length-1) - j;
			powerConstantTemp /= 2;
			if(residue >= powerConstantTemp) {
				onePossibility.add((Long) nums[j]);
				residue -= (powerConstantTemp);
				sum += (Long) nums[j];
				
				if(sum > targetSum) {
					break;
				}
			}
		}
		
		if(sum == targetSum) {
			foundIt = true;
			solution = onePossibility;
		}
					
		return foundIt;
	}
	
	public static boolean findAllPossibilities(Object[] nums) {
		boolean foundIt = false;
		for(int i = 1; i <= powerConstant; i++) {
			foundIt = findAPossibility(nums, i);
			
			if(foundIt) {
				break;
			}
		}
		
		return foundIt;
	}
	

	
	public static void loadNumbers(List<String> fileContents) {
		for(String line : fileContents) {
			String[] splitNumList = line.split(", ");
			for(String num : splitNumList) {
				integerList.add(Long.parseLong(num));
			} 
		}
	}

	
	private static int getRandomNumber() {
		
		int randomInt = rnd.nextInt((int)Math.pow(2, 26))+1; // 1 to 2^26
		return randomInt;
	}
}
