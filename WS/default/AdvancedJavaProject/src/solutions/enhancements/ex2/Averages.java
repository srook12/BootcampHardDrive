package solutions.enhancements.ex2;

public class Averages {

    public static void main(String[] args) {
        System.out.print("The average is: ");
        System.out.println(averageInt(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        double result = averageDouble(1.2, 2.3, 3.4, 4.5);
        System.out.print("The average is: ");
        System.out.println(result);
    }

    public static int averageInt(int ... values ){
        int total = 0;
        for(int x : values){
            total += x;
        }
        return total/values.length;
    }
    
    public static double averageDouble(double... values) {
        double total = 0;
        for (double x : values) {
            total += x;
        }
        return total / values.length;
    }
}
