import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.*;

public class Pokemon_Platinum_Game {
	private Map_Storage map_storage;
	private ArrayList<Pokemon_Map> maps = new ArrayList<>();
	private Player player;
	private Pokemon_Map current_map;
	public Pokemon_Platinum_Game() throws IOException {
		this.map_storage = new Map_Storage();
		this.player = new Player("Cynthia", "Cynthia", Direction.DOWN);
		this.current_map = map_storage.getMap_storage().get(0);
		this.player.setGrid_x(11);
		this.player.setGrid_y(11);
	}
	
	// What do you want to do when a key is hit?
	public void keyHit(String s) 
	{
		Tile[][] temp = current_map.getGrid();
		int r = player.getGrid_y();
		int c = player.getGrid_x();
		
		if (s.equals("up"))
		{
			if (player.isCan_move() == true) 
			{
				if (player.getDirection() == Direction.UP)
				{
					if (r > 0 && temp[r - 1][c].getType() <= 1)
					{
						player.setGrid_y(r - 1);
					}
					else if (r > 0 && temp[r - 1][c].getType() == 9)
					{	
						player.setGrid_y(this.current_map.getTile(r - 1, c).getWarp().getRow());
						player.setGrid_x(this.current_map.getTile(r - 1, c).getWarp().getCol());
						this.current_map = map_storage.getMap_storage().get(this.current_map.getTile(r - 1, c).getWarp().getWarp_index());
					}
				}
			}
			player.setDirection(Direction.UP);
		}
		else if (s.equals("down"))
		{
			if (player.isCan_move() == true && player.getDirection() == Direction.DOWN && r < temp.length - 1 && temp[r + 1][c].getType() <= 1)
			{
				player.setGrid_y(r + 1);
			}
			player.setDirection(Direction.DOWN);
		}
		else if (s.equals("left"))
		{
			if (player.isCan_move() == true && player.getDirection() == Direction.LEFT && c > 0 && temp[r][c - 1].getType() <= 1)
			{
				player.setGrid_x(c - 1);
			}
			player.setDirection(Direction.LEFT);
		}
		else if (s.equals("right"))
		{
			if (player.isCan_move() == true && player.getDirection() == Direction.RIGHT && c < temp[r].length - 1 && temp[r][c + 1].getType() <= 1)
			{
				player.setGrid_x(c + 1);
			}
			player.setDirection(Direction.RIGHT);
		}
		System.out.println("Player moved "+s);
		
		
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public Pokemon_Map getCurrent_map()
	{
		return current_map;
	}
}
