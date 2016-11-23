package solutions.review.ex1;

public class Person {
    protected String firstName;
    protected String lastName;
    
    public Person(){
        this("Jane", "Doe");
    }
    
    public Person(String first, String last){
        firstName = first;
        lastName = last;
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

    public String toString(){
        StringBuffer sb =
            new StringBuffer(lastName);
        sb.append(", ").append(firstName);
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p);
        p = new Person("Joe", "Smith");
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
        System.out.println(p);
        
    }
}