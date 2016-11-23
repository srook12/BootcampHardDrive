package solutions.enhancements.ex3;

public class Averages {

    public static void main(String[] args) {
        System.out.print("The average is: ");
        System.out.println(averageInt(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        double result = average(1.2, 2.3, 3.4, 4.5);
        System.out.print("The average is: ");
        System.out.println(result);
        
        String formatted = average(5, 1.2, 2.3, 3.4, 4.5);
        System.out.print("The formatted average is: ");
        System.out.println(formatted);
    }

    public static int averageInt(int ... values ){
        int total = 0;
        for(int x : values){
            total += x;
        }
        return total/values.length;
    }
    
    public static double average(double... values) {
        double total = 0;
        for (double x : values) {
            total += x;
        }
        return total / values.length;
    }
    
    public static String average(int places, double... values) {
        double total = 0;
        for (double x : values) {
            total += x;
        }
        String format = "%." + places + "f";
        return String.format(format, total / values.length);
    }
}
