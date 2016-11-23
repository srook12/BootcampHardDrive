package textgame;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static final String MONSTER = "MONSTER";
	public static final String TREASURE = "TREASURE";
	public static final String NORTH = "NORTH";
	public static final String EAST = "EAST";
	public static final String SOUTH = "SOUTH";
	public static final String WEST = "WEST";
	public static final String GRAB = "GRAB";
	public static final String ATTACK = "ATTACK";
	public static final String LOOK = "LOOK";
	public static final String INVENTORY = "INVENTORY";
		
	public static void main(String[] args) {
		// Load command list
		List<String> commands = FileUtils.getFileContents("commands.txt");
		List<BaseObject> objects = new ArrayList<BaseObject>();

		// New player
		Player player = new Player();
		
		for(String command : commands) {
			System.out.println(command);
			String[] commandParts = parse(command);
			
			switch(commandParts[0].toUpperCase()) {
				case MONSTER:
					objects.add(new Monster(
							new Location(Integer.parseInt(commandParts[1]), 
									     Integer.parseInt(commandParts[2])),
							Integer.parseInt(commandParts[3]),
							Integer.parseInt(commandParts[4]),
							commandParts[5]));
					break;
				case TREASURE:
					objects.add(new Treasure(
							new Location(Integer.parseInt(commandParts[1]), 
								     Integer.parseInt(commandParts[2])),
							Integer.parseInt(commandParts[3]),
							commandParts[4]));
					break;
				case NORTH:
					player.move(Direction.NORTH);
					break;
				case EAST:
					player.move(Direction.EAST);
					break;
				case SOUTH:
					player.move(Direction.SOUTH);
					break;
				case WEST:
					player.move(Direction.WEST);
					break;
					
			}
		}
	}

	public static String[] parse(String command) {
		return command.split(" ");
	}
}
