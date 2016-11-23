package examples.review;

public class SimpleClass {
    private boolean a, b = true;
    private int x, y = 99;
    private String s, t = "Hello";

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(a).append(':').append(b);
        sb.append('\t');
        sb.append(x).append(':').append(y);
        sb.append('\t');
        sb.append(s).append(':').append(t);
        return sb.toString();
    }

    public static void main(String[] args) {
        SimpleClass sc = new SimpleClass();
        System.out.println(sc);
    }
}