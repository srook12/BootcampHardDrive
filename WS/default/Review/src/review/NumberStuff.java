package review;

public class NumberStuff {

	public static void main(String[] args) {
		int[] nums = new int[args.length];
		int sum = 0;
		int largest = -1;
		
		System.out.print("The numbers are: ");
		
		for(int i = 0; i < args.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
			sum += nums[i];
			
			if(nums[i] > largest) {
				largest = nums[i];
			}
			
			System.out.print(nums[i]);
			
			if(i < args.length - 1)
				System.out.print(", ");
		}

		System.out.format("\nThe average is %.2f\n", (sum/1.0)/nums.length);
		System.out.println("The largest number is " + largest);
	}

}
