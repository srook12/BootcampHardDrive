package examples.enhancements;

import java.util.Calendar;

public class Employee {
    private String firstName, lastName;
    private Calendar hireDate;
    private int id;
    private static int idGenerator = 800;
    public Employee(String firstName,
            String lastName, Calendar hireDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.id = idGenerator += 100;
    }
    public String getFirstName() {
        return firstName;
    }
    public Calendar getHireDate() {
        return hireDate;
    }
    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
}