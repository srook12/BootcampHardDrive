package examples.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class JustATest {
    public static void main(String[] args) {
	
    	//ArrayList<Object> listA = new ArrayList<Object>();
    	ArrayList<String> listA = new ArrayList<String>();
    	listA.add("Hello");
    	listA.add("Goodbye");
    	
    	System.out.println(WithGenerics.length1(listA));
    }
    public static void print(Collection<?> c){
	    Iterator<?> iterator = c.iterator();
	    for( int i = 0; i < c.size(); i++){
	        System.out.println(iterator.next());
	    }
	}
}
