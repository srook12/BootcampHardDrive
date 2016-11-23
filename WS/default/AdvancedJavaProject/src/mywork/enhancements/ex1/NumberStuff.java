package mywork.enhancements.ex1;

public class NumberStuff {

	public static void main(String[] args) {
		int[] numArray = new int[args.length];
		int numPlaces = 2;
		for(int i = 0; i < numArray.length; i++)
			numArray[i] = Integer.parseInt(args[i]);
			
		System.out.printf("Average: %." + numPlaces + "f", average(numArray));		
	}
	
	public static double average(int... nums) {
		int sum = 0;
		for(int num : nums)
			sum += num;
		
		return (sum * 1.0) / nums.length;
	}

}
