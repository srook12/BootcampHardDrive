package mywork.packaging.ex1;

/**
 * The {@code Person} class is used to construct a generic person object
 * 
 * @author SJR
 * @since Now
 */

public class Person {
	/**
	 * A representation of a person's first name.
	 * 
	 */
    protected String firstName;
    
    /**
	 * A representation of a person's last name.
	 * 
	 */
    protected String lastName;
    
    /**
     * Represents an anonymous person without a first nor last name.
     */    
    public Person(){
        firstName = "Jane";
        lastName = "Doe";
    }
    
    /**
     * Represents a person with the given first and last name 
     * @param first The person's first name
     * @param last The person's last name
     */
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

    /**
     * Mutator that allows the first name of a Person object to be changed.
     * 
     * @param firstName The new first name of a Person object.
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Represents the printable version of a person object.
	 * 
	 * @return A string representing the printable version of a person object.
	 */
	public String toString() {
		return lastName + ", " + firstName;
	}
}
