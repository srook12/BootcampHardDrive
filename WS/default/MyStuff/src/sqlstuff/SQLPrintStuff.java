package sqlstuff;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SQLPrintStuff {

	private static java.util.Random rnd = new java.util.Random((new java.util.Date()).getTime());
	public static PrintWriter pw;
	
	static int[] ids = {100, 110, 120, 130, 140, 150, 160, 170, 180, 190};
	
	public static void main(String[] args) throws FileNotFoundException {
		pw = new PrintWriter("major_req.sql");
		
		//printRecords();
		//printMajorReqs();
	}
	
	public static void printRecords() {
		int id = 1;
		for(int student_id : ids) {
			for(int assignment = 1; assignment <= 5; assignment++, id++) {
				pw.println(id + "\t" + student_id + "\t" + assignment + "\t"
						+ getRandomScore());
			}
		}
		pw.flush();
	}
	
	public static int getRandomScore() {
		
		int randomInt = rnd.nextInt(5); // 0-4
		return randomInt;
	}

}
