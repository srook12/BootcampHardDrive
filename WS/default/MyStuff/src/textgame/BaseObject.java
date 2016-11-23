package textgame;

public class BaseObject {
	private Location location;
	private String description;
	
	public BaseObject(Location location, String description) {
		setLocation(location);
		setDescription(description);
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
