package solutions.packaging.ex1;

/**
 * The <code>Person</code> class represents a person.
 * The class includes methods for setting and getting
 * the first and/or last name of the person.
 * @author /training/etc
 *
 */
public class Person {
    
    /**
     * The first name of a person
     */
    protected String firstName;
    /**
     * The last name of a person
     */
    protected String lastName;
    
    /**
     * Creates a "default" person by assinging it a
     * first name of "Jane" and a last name of "Doe".
     */
    public Person(){
        this("Jane", "Doe");
    }
    /**
     * Initializes a <code>Person</code> with a
     * <code>first</code> and <code>last</code> name.
     * @param first First name of <code>Person</code>
     * @param last Last name of <code>Person</code>
     */
    public Person(String first, String last){
        firstName = first;
        lastName = last;
    }
    
    /**
     * Returns the first name of the <code>Person</code>
     * @return The first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of this <code>Person</code>
     * to the specified value.
     * @param firstName The first name of this <code>Person</code>
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the <code>Person</code>
     * @return The last name
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Sets the last name of this <code>Person</code>
     * to the specified value.
     * @param lastName The last name of this <code>Person</code>
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /** 
     * Returns a <code>String</code> representing the
     * name of the person as last name, first name.
     * @return a <code>String</code> representing the 
     *    name of this <code>Person</code>.
     */
    public String toString(){
        StringBuffer sb =
            new StringBuffer(lastName);
        sb.append(", ").append(firstName);
        return sb.toString();
    }
    
    /**
     * For Testing purposes only.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p);
        p = new Person("Joe", "Smith");
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
        System.out.println(p);
    }
}