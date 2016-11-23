package mywork.enhancements.ex3;

public class NumberStuff3 {

	public static void main(String[] args) {
		int[] intArray = {3, 7, 12, 99};
		double[] doubleArray = {2.65, 100.2, 97.68};
					
		System.out.printf("Average of the ints: %.2f\n", average(intArray));		
		System.out.printf("Average of the doubles: %.2f\n", average(doubleArray));
		System.out.println(average(3, doubleArray));
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
	
	public static String average(int numPlaces, double... nums) {
		return String.format("Average of the doubles to %d places: %." + numPlaces  + "f", numPlaces, average(nums));
	}

}
