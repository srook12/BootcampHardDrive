package examples.review;

public class SimpleDate extends AbstractDate {
    int data [] = new int[3];
    public SimpleDate(int month, int day, int year){
        data[0] = day;
        data[1] = month;
        data[2] = year;
    }
    public int getDay() {  return data[0]; }

    public int getMonth() { return data[1]; }

    public int getYear() { return data[2]; }
}