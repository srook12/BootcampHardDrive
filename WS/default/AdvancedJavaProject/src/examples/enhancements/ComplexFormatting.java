package examples.enhancements;

import java.util.GregorianCalendar;

public class ComplexFormatting {
    public static void main(String args[]){
        Employee employee [] = new Employee[3];
        employee[0] = new Employee("Joe", "Smith",
                new GregorianCalendar(2008,0,1));
        employee[1] = new Employee("Michelle",
                "McDonald",
                new GregorianCalendar(2008,9,10));
        employee[2] = new Employee("Peter", "Jones",
                new GregorianCalendar(2008,4,17));
        for(Employee e:employee){
            printf("%1$-10s|%2$-10s|%3$5d|%4$tD" ,
                    e.getFirstName(),
                    e.getLastName(),
                    e.getId(),
                    e.getHireDate());
        }
    }
    public static void printf(String f, Object ...a){
        System.out.printf(f + "%n", a);
    }
}