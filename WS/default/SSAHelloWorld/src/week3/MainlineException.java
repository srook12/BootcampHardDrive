package week3;

public class MainlineException {

	public static void main(String[] args) throws Exception {
		/*
		try {
			int[] ints = new int[5];
			int oneInt = ints[5];
		} catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("We got a " + ex);
			throw new Exception("x");
		} catch (Exception ex) {
			
		}

		System.out.println("The program ended");
		*/
		
		//Account account = new Account();
	}

}

abstract class Account {
	
	
	public Account() {
		
	}
	
	public abstract String display();
}

class MyException extends Exception {
	public MyException() {
		super("Cannot deposit or withdraw a negative amount!");
	}
}