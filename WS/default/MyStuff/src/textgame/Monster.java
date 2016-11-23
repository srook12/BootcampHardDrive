package textgame;

public class Monster extends BaseObject {
	private int strength;
	private int force;
	
	public Monster(Location location, int strength, int force, String description) {
		super(location, description);
		setStrength(strength);
		setForce(force);
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}	
	
	@Override
	public String toString() {
		return getDescription() + " with HP " + getStrength();
	}
}
