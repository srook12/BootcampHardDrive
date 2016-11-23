package review;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileStuff2 {

	public static void main(String[] args) {
		// Read in the lines from the file
		BufferedReader br = null;
		int size = 0, capacity = 100;
		String[] myWordList = new String[capacity];
		 List<String> myWordList2 = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader("words.txt"));
			String aWord;
			
			while((aWord = br.readLine()) != null) {
				myWordList[size] = aWord;
				// myWordList.add(aWord);
				size++;
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
		String[] myWordListArray = null;
		myWordList = myWordList2.toArray(myWordListArray);
		//Arrays.sort(myWordList.toArray());
		
		/*
		Object[] myWordListArray = myWordList.toArray();
		Arrays.sort(myWordListArray);
		*/
		
		Arrays.sort(myWordList, 0, size);
		
		PrintWriter pw = null;
				
		try {
			pw = new PrintWriter(new FileWriter("sorted-output.txt"));
			
			for(int i = 0; i < size; i++) {
				pw.print(myWordList[i]);
				if(i < size - 1)
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
