package examples.review;

public class StaticBlock {
    static {
        System.out.println("StaticBlock loaded");
    }
    public static void main(String args[]) {
        new One();
        new One();
    }
}

class One {
    static {
        System.out.println("One has been loaded");
    }
    public One() {
        System.out.println("One's constructor");
    }
    static {
        System.out.println("Additional Output");
    }
}