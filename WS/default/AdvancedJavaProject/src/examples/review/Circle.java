package examples.review;
public class Circle {
    int xc, yc, radius;

    public Circle(int x, int y, int rad) {
        xc = x;
        yc = y;
        radius = rad;
    }
    public Circle(int x, int y) {
        this(x, y, 1);
    }
    public Circle(int rad) {
        this(0, 0, rad);
    }
    public Circle() {
        this(0, 0, 1);
    }
}