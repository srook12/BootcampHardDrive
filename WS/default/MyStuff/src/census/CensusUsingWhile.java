package census;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CensusUsingWhile {
	
	static List<Integer> integerList = new ArrayList<Integer>();
	
	static List<Integer> solution = new ArrayList<Integer>();
	
	static long targetSum;
		
	static int powerConstant;
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println("CensusUsingWhile started at " + startTime + " ms\n");
		
		if(args.length != 2) {
			System.err.println("Usage: CensusUsingWhile <List of #s> <Target Sum>");
			System.exit(1);
		}
					
		solve(args[0], args[1]);
		
		long endTime = System.currentTimeMillis();
		System.out.println("CensusUsingWhile ended at " + endTime + " ms");		
		System.out.println("CensusUsingWhile took " + (endTime-startTime)/1000.0 + " s to run.");

	}
	
	public static void solve(String fileName, String targetSumAsString) {
		List<String> fileContents = FileUtils.getFileContents(fileName);
		loadNumbers(fileContents);
		
		powerConstant = (int) Math.pow(2, integerList.size());
		
		targetSum = Long.parseLong(targetSumAsString);
		
		Collections.sort(integerList);	
		
		findSolutionFor();
		
		System.out.println(getSolution());
		System.out.println();
	}

	public static void findSolutionWhile() {
		int positionToTry = 0;
		boolean foundIt = false;
		
		while(!foundIt) {
			String bitString = Integer.toBinaryString(positionToTry);
			
			//System.out.println("==================");
			//System.out.print("For positionToTry " + positionToTry + ", the string is: " + bitString);
			//System.out.println();
			foundIt = doSummation(bitString);
			//System.out.println("==================");
			positionToTry++;
		}
	}
	
	public static void findSolutionFor() {
		int positionToTry = 0;
		boolean foundIt = false;
		int powerConstant = (int) Math.pow(2, integerList.size());
		for(int i = 0; i < powerConstant; i++) {
			String bitString = Integer.toBinaryString(positionToTry);
			
			//System.out.println("==================");
			//System.out.print("For positionToTry " + positionToTry + ", the string is: " + bitString);
			//System.out.println();
			foundIt = doSummation(bitString);
			if(foundIt) {
				break;
			}
			//System.out.println("==================");
			positionToTry++;
		}
	}
	
	public static boolean doSummation(String bitString) {
		boolean foundIt = false;
		int sumSoFar = 0;
		solution.clear();
		
		for(int idx = bitString.length() - 1; idx >= 0; idx--) {
			if(bitString.charAt(idx) == '1') {
				sumSoFar += integerList.get(integerList.size() - idx - 1);
				solution.add(integerList.get(integerList.size() - idx - 1));
				//System.out.println("Sum so far " + sumSoFar);
			}
			
			if(sumSoFar == targetSum) {
				foundIt = true;
				break;
			} else if(sumSoFar > targetSum) {
				//System.out.println("Over... breaking!");
				break;
			}
		}
		
		return foundIt;
	}
	
	public static void loadNumbers(List<String> fileContents) {
		for(String line : fileContents) {
			String[] splitNumList = line.split(", ");
			for(String num : splitNumList) {
				integerList.add(Integer.parseInt(num));
			} 
		}
	}
	
	public static String getSolution() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Solution found for target sum " + targetSum);
		sb.append(":\n==============\n");
		int counter = 0;
		for(Integer number : solution) {
			counter++;
			sb.append(String.format("%-10d   ", number));
			if(counter % 8 == 0 && counter < integerList.size()) {
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
}
