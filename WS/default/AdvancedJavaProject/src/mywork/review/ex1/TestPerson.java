package mywork.review.ex1;

public class TestPerson {
	public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p);
        
        Person p1 = new Person("Bowser", "Koopa");
        System.out.println(p1);

        Person p2 = new Person("John", "Smith");
        System.out.println(p2);

    }
}
