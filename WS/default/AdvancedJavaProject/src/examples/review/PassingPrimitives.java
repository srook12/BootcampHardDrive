package examples.review;
public class PassingPrimitives {
    public static void main(String[] args) {
        // change method cannot modify primitive data
        // being passed as argument to method
        int x = 10;
        change(x); 
        System.out.println(x);

        // change method can modify object whose
        // reference is passed as argument to method
        int data[] = {x};
        change(data);
        System.out.println(data[0]);
    }
    public static void change(int p) { p = 20; }

    public static void change(int p[]) { p[0] = 20; }
}