package examples.review;
public class StringBufferTest{
    public static void main(String args[]){
        StringBuffer sb = new StringBuffer();
        info(sb);
        info(sb.append(123456789));
        info(sb.insert(0, "abcdefghi"));
        info(sb.replace(2, 5, "Hello"));
        sb.setLength(0);
        info(sb);
    }
    public static void info(StringBuffer sb){
        System.out.print("len:" + sb.length());
        System.out.print(" cap:" + sb.capacity());
        System.out.print(" data: " + sb);
        System.out.println();
    }
}