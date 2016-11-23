package examples.threads;
import java.util.*;
public class PrintingUtils{
    public static void print(int x[]){
        Arrays.sort(x);
        for(int i = 0; i < x.length; i++){
            System.out.print(x[i]);
            if(i < x.length - 1)
                System.out.print(",");
        }
        System.out.println();
    }
}