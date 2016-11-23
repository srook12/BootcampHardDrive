package examples.review;

public class Person {
    protected String firstName;
    protected String lastName;
    
    public void Person(){
        firstName = "Jane";
        lastName = "Doe";
    }

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.firstName);
        System.out.println(p.lastName);
    }
}