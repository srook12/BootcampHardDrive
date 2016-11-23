package examples.enhancements;

public class FormattedStrings {
    public static void main(String args[]){
        String text [] = {
                "Goodbye",
                "Hello",
                "A String of 25 characters",
                "goodbye",
                "hello",
        };
        printf("%s",text[0]);
        printf("%S",text);
        printf("%.4S",text);
        System.out.println("----------------------");
        for(String t:text){
            printf("%30s", t);
        }
        
    }
    public static void printf(String f, Object ...a){
        System.out.printf(f + "%n", a);
    }
}