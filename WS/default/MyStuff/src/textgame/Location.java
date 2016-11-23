package textgame;

public class Location {
	private int x;
	private int y;
	
	public Location(int x, int y) {
		setX(x);
		setY(y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean isEqual = false;
		
		if(object instanceof Location) {
			isEqual = (getX() == ((Location) object).getX()) && 
					(getY() == ((Location) object).getY());
		}
		
		return isEqual;
	}
}
