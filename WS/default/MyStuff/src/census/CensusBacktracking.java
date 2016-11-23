package census;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CensusBacktracking {

	static List<Long> numberList = new ArrayList<Long>();
	
	static Stack<Long> solution = new Stack<Long>();
		
	static long targetSum;
	static long sumSoFar;
	
	static boolean foundIt = false;
	
	public static final String ADD = "Adding to the solution set: ";
	public static final String REMOVE = "Removing from the solution set: ";
	public static final String CURR_SUM = "Current sum is: ";
	public static final String EXCEED_SUM1 = "Current sum of ";
	public static final String EXCEED_SUM2 = " exceeds the target sum of ";
	public static final String NO_MORE_NUMS = "No more numbers left. ";
	
	public static final String BACKTRACKING = "Backtracking...";
	
	public static final String NUMBER_FORMAT = "#,##0";
	public static DecimalFormat formatter = new DecimalFormat(NUMBER_FORMAT);
	
	static PrintWriter pw;
	
	public static void main(String[] args) {
		if(args.length != 2) {
			System.err.println("Usage: CensusBacktracking <List of #s> <Target Sum>");
			System.exit(1);
		}
		
		long startTime = System.currentTimeMillis();
		System.out.println("CensusBacktracking started at " + startTime + " ms");
		
		//solve(args[0], args[1]);

		long endTime = System.currentTimeMillis();
		System.out.println("CensusBacktracking ended at " + endTime + " ms");		
		System.out.println("CensusBacktracking took " + (endTime-startTime)/1000.0 + " s to run.");
	}
	/*
	public static void solve(String fileName, String targetSumString) {
		try {
			pw = new PrintWriter("log.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> fileContents = FileUtils.getFileContents(fileName);
		loadNumbers(fileContents);
		
		targetSum = Long.parseLong(targetSumString);
		
		// Sort the list in ascending order
		Collections.sort(numberList);
		
		System.out.println("Starting:");
		for(int idx = numberList.size() - 1; idx >= 0; idx--) {
			System.out.print(formatter.format(numberList.get(idx)) + "=" + idx + "\t");
			if((idx-1) % 5 == 0 || (idx) == 0) {
				System.out.println();
			}
		}
		

		for(int idx = numberList.size() - 1; idx >= 0; idx--) {
			maxIndex = idx;
			log("Root level: ", false);
			add(numberList.get(idx));
			log("Root level: ", false);
			log("Value of idx: " + idx, false);
			// Recurse
			foundIt = recurse();
			
			// Check to see if a solution has been found
			if(foundIt) {
				log(getSolution(), false);
				System.out.println();
				break;
			}
		}
		
	}
	
	public static boolean recurse(int maxIndex) {
		if(sumSoFar == targetSum) {
			return true;
		} else if((sumSoFar > targetSum) || (maxIndex < 0)) {
			if(sumSoFar > targetSum) {
				log(EXCEED_SUM1 + sumSoFar + EXCEED_SUM2 + targetSum + ". " + BACKTRACKING, false);
			} else {
				log(NO_MORE_NUMS + ". " + BACKTRACKING, false);
			}			
			remove();
			return false;
		}  else {
			add(numberList.get(idx));
			return recurse(idx - 1);
			
		}
	}
	
	
	public static void setSumSoFar(long value) {
		sumSoFar += value;
	}
	
	public static void add(long value) {
		solution.push(value);
		setSumSoFar(solution.peek());
		log(ADD + formatter.format(solution.peek()), true);
		log("Value of maxIndex before adding: " + maxIndex, false);
		maxIndex--;
		log("Value of maxIndex after adding: " + maxIndex, false);
	}
	
	public static void remove() {
		setSumSoFar(solution.peek()*-1);
		log(REMOVE + formatter.format(solution.pop()), true);
		log("Value of maxIndex before removing: " + maxIndex, false);
		//maxIndex++;
		log("Value of maxIndex before removing: " + maxIndex, false);
	}

	public static void loadNumbers(List<String> fileContents) {
		for(String line : fileContents) {
			String[] splitNumList = line.split(", ");
			for(String num : splitNumList) {
				numberList.add(Long.parseLong(num));
			} 
		}
	}
	
	public static String getSolutionSoFar() {
		StringBuffer sb = new StringBuffer();		
		sb.append(CURR_SUM + formatter.format(sumSoFar)).append("  ");
		pw.println();
		sb.append("Solution so far: ");
		for(int idx = solution.size()-1; idx >= 0; idx--) {
			sb.append(formatter.format(solution.get(idx)) + " ");
		}
		sb.append("\n");
		
		return sb.toString();
	}
	
	public static void log(String message, boolean printSolutionSoFar) {
		pw.println(message);
		if(printSolutionSoFar) {
			pw.println(getSolutionSoFar());
		}
	}
	
	public static String getSolution() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("Solution found for target sum " + targetSum);
		sb.append(":\n==============\n");
		int counter = 0;
		for(Long number : solution) {
			counter++;
			sb.append(String.format("%-10d   ", number));
			if(counter % 8 == 0 && counter < numberList.size()) {
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
	*/
}
