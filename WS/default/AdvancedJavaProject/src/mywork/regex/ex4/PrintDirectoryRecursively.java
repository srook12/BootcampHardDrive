package mywork.regex.ex4;

import java.io.File;

import mywork.regex.ex3.FileRegex;

public class PrintDirectoryRecursively {
	public static FileRegex fileRegex;
	
	public static void main(String[] args) {
		printDirectoryRecursively(args[0], args[1]);
	}
	
	public static void printDirectoryRecursively(String dirPath, String regex) {
		
		print(new File(dirPath).listFiles(), 0);
	}
	
	public static void print(File[] directoryFileList, int index) {
		if(index < directoryFileList.length) {
			File currFile = directoryFileList[index];
			if(currFile.isDirectory()) {
				print(currFile.listFiles(), 0);
			} 
				
			System.out.println(currFile.getAbsolutePath());
			print(directoryFileList, index+1);
			
		}
	}
}
