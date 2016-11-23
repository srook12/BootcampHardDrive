package examples.collections;

public class Fraction implements Comparable {
    private int n, d;

    public Fraction(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public String toString() {
        return n + "/" + d;
    }

    public int compareTo(Object o) {
        System.out.print("Comparing: ");
        System.out.println (this + " and " + o);
        Fraction f1 = (Fraction) o;
        double hostVal = (double) n / d;
        double paramVal = (double) f1.n / f1.d;
        if (hostVal == paramVal)
            return 0;
        else if (hostVal < paramVal)
            return -1;
        else
            return 1;
    }
}