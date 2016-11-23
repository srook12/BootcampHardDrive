package examples.review;
import java.util.Enumeration;
public class WrapperClasses {
    public static void main(String[] args){
        int sum = 0;
        java.util.Vector v = new java.util.Vector();
        v.add(new Integer(10));
        v.add(new Integer(20));
        Enumeration e = v.elements();
        while(e.hasMoreElements()){
            Integer temp = (Integer) e.nextElement();
            sum += temp.intValue();
        }
        System.out.println("Total is " + sum);
        
        sum = 0;
        for(int i = 0; i < args.length; i++){
            sum += Integer.parseInt(args[i]);
        }
        System.out.println("Total is " + sum);
    }
}