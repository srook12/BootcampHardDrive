package theironyard.chess;

public class Knight {
	private int x;
	private int y;
		
	private int startX;
	private int startY;
	
	public Knight() {
		this(0, 0);
	}
	
	public Knight(int x, int y) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
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
		
	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public boolean isLegalKnightMove(int x, int y) {
		if( (x == (this.x + 2) && y == (this.y + 1)) && 
			(x == (this.x + 2) && y == (this.y - 1)) &&
			(x == (this.x - 2) && y == (this.y + 1)) && 
			(x == (this.x - 2) && y == (this.y - 1)) &&
			(x == (this.x + 1) && y == (this.y + 2)) &&
			(x == (this.x - 1) && y == (this.y + 2)) &&
			(x == (this.x + 1) && y == (this.y - 2)) &&
			(x == (this.x - 1) && y == (this.y - 2)) ) {
			return true;
		}
		
		return false;
	}
	
	public boolean hasReturnedToStart() {
		return (x == startX) && (y == startY);
	}
	
	public void moveKnight(int x, int y) {
		if(isLegalKnightMove(x, y)) {
			setX(x);
			setY(y);
		}
		else {
			System.out.println("Illegal move!");
		}
	}
}
