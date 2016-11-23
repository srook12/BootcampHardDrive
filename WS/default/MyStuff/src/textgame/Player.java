package textgame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	Location location;
	int damageTaken;
	List<Treasure> inventory;
	
	public Player() {
		location = new Location(0, 0);
		inventory = new ArrayList<Treasure>();
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getDamageTaken() {
		return damageTaken;
	}

	public void setDamageTaken(int damageTaken) {
		this.damageTaken = damageTaken;
	}

	public List<Treasure> getInventory() {
		return inventory;
	}

	public void setInventory(List<Treasure> inventory) {
		this.inventory = inventory;
	}

	public void move(Direction direction) {
		switch(direction) {
			case NORTH:
				location.setY(location.getY() + 1);
				break;
			case EAST:
				location.setX(location.getX() + 1);
				break;
			case SOUTH:
				location.setY(location.getY() - 1);
				break;
			case WEST:
				location.setX(location.getX() - 1);
				break;
		}
	}
	
	public String inventory() {
		StringBuffer sb = new StringBuffer();

		sb.append("Current location is (" + getLocation().getX() + ", " + 
				getLocation().getY() + ")");
		sb.append("\n");
		sb.append("Damage taken: " + getDamageTaken());
		sb.append("\n");
		sb.append(String.format("%-30s   %4d", "Item", "Value"));
		
		for(Treasure treasure : getInventory()) {
			sb.append(String.format("%-30s   %4d", treasure.getDescription(), 
					treasure.getValue()));
			sb.append("\n");
		}

		return sb.toString();
	}
}
