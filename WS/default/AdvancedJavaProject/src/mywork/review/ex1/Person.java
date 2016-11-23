package mywork.review.ex1;

import java.util.StringTokenizer;

public class Person {
    protected String firstName;
    protected String lastName;
        
    public Person(){
        firstName = "Jane";
        lastName = "Doe";
    }
    
    public Person(String first, String last) {
    	firstName = first;
    	lastName = last;
    }
    
    public Person(String fullName) {
    	String[] name = fullName.split(" ");
    	firstName = name[0];
    	lastName = name[1];
    }
    

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {
		return lastName + ", " + firstName;
	}
}
