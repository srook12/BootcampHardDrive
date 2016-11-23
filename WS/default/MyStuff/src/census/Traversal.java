package census;

public class Traversal {

	static char[] array = {'a', 'b', 'c'};
	static boolean[] used = {false, false, false};
	
	public static void main(String[] args) {
		recurse(2);
		

	}
	
	public static void recurse(int idx) {
		if(idx < 0) {
			System.out.println();
			return;
		} else {
			for(int temp = idx; temp >= 0; temp--) {
				System.out.print(array[temp]);
				recurse(temp - 1);
			}
		}
	}

}
