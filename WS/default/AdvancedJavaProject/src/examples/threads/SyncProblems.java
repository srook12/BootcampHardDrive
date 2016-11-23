package examples.threads;
public class SyncProblems extends Thread{
    public static void main(String args[]){
        int odds [][] = {{9, 8, 7, 6, 5, 4, 3, 2, 1},
                {52, 22, 32, 72}, {43, 83, 63, 3},
                {24, 94, 54, 84}, {15, 65, 85, 5},
                {36, 26, 66, 56}, {97, 17, 37, 7}};
        Thread t1;
        for(int i = 0; i < odds.length; i++){
            t1 = new SyncProblems(odds[i]);
            t1.start();
        }
    }
    int a [];
    public SyncProblems(int a []){
        this.a = a;
    }
    public void run(){
        PrintingUtils.print(a);
    }
}


