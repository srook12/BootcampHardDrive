package mywork.regex.ex4;

import java.io.File;

public class PrintDirectory {

	public static FileRegex fileRegex;
	
	public static void main(String[] args) {
		
		printSingleDirectory(args[0], args[1]);
	}
	
	public static void printSingleDirectory(String dirPath, String regex) {
		File directory = new File(dirPath);
		fileRegex = new FileRegex(regex);
		
		for(File currFile : directory.listFiles(fileRegex)) {
			if(currFile.isDirectory()) {
				System.out.println(directory.getAbsolutePath() + "\\" + currFile.getName() + " is a directory.");
			} else {
				System.out.println(directory.getAbsolutePath() + "\\" + currFile.getName());
			}
		}
	}

}
