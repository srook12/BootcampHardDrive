package examples.enhancements;

public class ForEachWithArray {
    public static void main(String args[]){
        int a [] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 0;
        for(int i:a)
            sum += i;
        System.out.println(sum);
    }
}