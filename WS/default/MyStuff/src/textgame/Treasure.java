package textgame;

public class Treasure extends BaseObject {
	int value;
	
	public Treasure(Location location, int value, String description) {
		super(location, description);
		setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}	
	
	@Override
	public String toString() {
		return getDescription() + " with a value of " + getValue();
	}
}
