package solutions.regex.ex3;

import java.io.File;

public class FileFinder {
	private static String regex;
    public static void main(String args[]) {
        File f = new File(args[0]);
        regex = args[1];
        if ( f.exists() && f.isDirectory()){
        	print("Files matching " + regex);
        	println(" in " + f.getPath());
            listFiles(f);
        }
        else {
            println(f + " is not a valid directory");
        }
    }
    
    public static void listFiles(File dir){
		String names [] = dir.list();
		for(String name : names){
			if(name.matches(regex)){
				println(dir + "\\" + name);
			}
		}
    }
    private static void println(String s){
    	System.out.println(s);
    }
    private static void print(String s){
    	System.out.print(s);
    }
}