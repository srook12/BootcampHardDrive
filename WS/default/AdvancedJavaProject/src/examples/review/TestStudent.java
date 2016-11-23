package examples.review;
public class TestStudent {
    public static void main(String argv[]) {
        System.out.println(Student.getNextID());
        Student s[] = { new Student(), new Student(),
                new Student(), new Student() };
        for (int i = 0; i < s.length; i++)
            System.out.println(s[i].getID());
        System.out.println(Student.getNextID());
    }
}
class Student {
    private static int idGenerator;
    private int studentID;

    public Student() {
        studentID = idGenerator++;
    }

    public int getID() {
        return studentID;
    }

    public static int getNextID() {
        return idGenerator;
    }
}