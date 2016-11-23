package mywork.enhancements.ex2;

public class NumberStuff2 {

	public static void main(String[] args) {
		int[] intArray = {3, 7, 12, 99};
		double[] doubleArray = {2.65, 100.2, 97.68};
		
		int numPlaces = 2;
			
		System.out.printf("Average of the ints: %." + numPlaces + "f\n", average(intArray));		
		System.out.printf("Average of the doubles: %." + numPlaces + "f", average(doubleArray));		
	}
	
	public static double average(int... nums) {
		int sum = 0;
		for(int num : nums)
			sum += num;
		
		return (sum * 1.0) / nums.length;
	}

	public static double average(double... nums) {
		double sum = 0;
		for(double num : nums)
			sum += num;
		
		return sum / nums.length;
	}

}
