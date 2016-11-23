package review;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FileStuff {

	public static void main(String[] args) {
		// Read in the lines from the file
		BufferedReader br = null;
		List<String> myWordList = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader("musicTerms.txt"));
			String aWord;
			
			while((aWord = br.readLine()) != null) {
				myWordList.add(aWord);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Convert
		String[] myWordListArray = new String[1];
		myWordListArray = myWordList.toArray(myWordListArray);
				
		Arrays.sort(myWordListArray);
		
		PrintWriter pw = null;
				
		try {
			pw = new PrintWriter(new FileWriter("sorted-output.txt"));
						
			for(int i = 0; i < myWordListArray.length; i++) {
				pw.print(myWordListArray[i]);
				if(i < myWordListArray.length - 1)
					pw.print(", ");
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(pw != null)
					pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}

}
