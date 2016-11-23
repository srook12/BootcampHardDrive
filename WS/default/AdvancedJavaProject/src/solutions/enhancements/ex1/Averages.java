package solutions.enhancements.ex1;

public class Averages {

    public static void main(String[] args) {
       System.out.print("The average is: ");
       System.out.println(averageInt(1,2,3,4,5,6,7,8,9,10));
    }

    public static int averageInt(int ... values ){
        int total = 0;
        for(int x : values){
            total += x;
        }
        return total/values.length;
    }
}
