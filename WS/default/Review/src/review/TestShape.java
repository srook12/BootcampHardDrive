package review;

import java.util.ArrayList;
import java.util.List;

public class TestShape {
	
	
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.home"));
		Canvas c = new Canvas();
		List<Rectangle> rectangleList = new ArrayList<Rectangle>();
		rectangleList.add(new Rectangle());
		rectangleList.add(new Rectangle());
		
		c.drawAll(rectangleList);
	}
	/*
	public void addRectangle(List<? extends Shape> shapes) {
	    // Compile-time error!
	    shapes.add(0, new Rectangle());
	}
*/
}

class Canvas {
	public void draw(Shape s) {
		s.draw(this);
	}
	
	public void drawAll(List<? extends Shape> shapes) {
		for(Shape s : shapes)
			s.draw(this);
	}
	
}

abstract class Shape {
	public abstract void draw(Canvas c);
}

class Rectangle extends Shape {
	public void draw(Canvas c) {
		System.out.println("Drawing a rectangle.");
	}
}

class Circle extends Shape {
    private int x, y, radius;
    public void draw(Canvas c) {
    	System.out.println("Drawing a circle.");
    }
}

