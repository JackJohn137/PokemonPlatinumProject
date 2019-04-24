import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Pokemon_Map {
	private final Image pokemon_map;
	private final String map_name;
	private ArrayList<Pokemon_Trainer> trainers;
	private int r;
	private int c;
	private Tile[][] grid;
	private final Map_Reader mr;
	
	public Pokemon_Map (String map_name, int initial_x, int initial_y) throws IOException
	{
		this.pokemon_map = ImageIO.read(getClass().getResource("pokemon_map/" + map_name + ".png"));
		this.map_name = map_name;
		this.mr = new Map_Reader(map_name);
		this.grid = mr.getGrid();
		this.r = initial_y;
		this.c = initial_x;
	}
	
	public Pokemon_Map (String map_name) throws IOException
	{
		this.pokemon_map = ImageIO.read(getClass().getResource("pokemon_map/" + map_name + ".png"));
		this.map_name = map_name;
		this.mr = new Map_Reader(map_name);
		this.grid = mr.getGrid();
		this.r = 0;
		this.c = 0;
	}
	
	public Tile getTile(int row, int col)
	{
		return grid[row][col];
	}
	
	public Tile[][] getGrid()
	{
		return grid;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public Image getPokemon_map() {
		return pokemon_map;
	}
	
	public void draw(Graphics g)
	{
		g.drawImage(getPokemon_map(), 0, 0, null);
	}

	public String getMap_name() {
		return map_name;
	}
}

	

