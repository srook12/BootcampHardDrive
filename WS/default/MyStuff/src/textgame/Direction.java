package textgame;

public enum Direction { NORTH("NORTH"), EAST("EAST"), SOUTH("SOUTH"), WEST("WEST");
		
	private String description;
	
	Direction(String description) {
		this.description = description;
	}
	
	public String getDescription() { return description; }
}
